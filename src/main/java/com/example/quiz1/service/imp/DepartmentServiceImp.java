package com.example.quiz1.service.imp;

import com.example.quiz1.dto.AddressDto;
import com.example.quiz1.dto.DepartmentDto;
import com.example.quiz1.entity.Address;
import com.example.quiz1.entity.Department;
import com.example.quiz1.exeption.ResourceNotFoundException;
import com.example.quiz1.repository.AddressRepository;
import com.example.quiz1.repository.DepartmentRepository;
import com.example.quiz1.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = mapToEntity(departmentDto);
        Department newDepartment = departmentRepository.save(department);

        return mapToDTO(newDepartment);
    }

    @Override
    public List<DepartmentDto> listAllDepartment() {
        List<Department> departments = new ArrayList<>();

        departmentRepository.findAll().forEach(departments::add);
        return departments.stream().map(this::mapToDTO)
                .collect(Collectors.toList());


    }

    @Override
    public DepartmentDto getDepartmentById(int departmentId) {

        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("department: ", "id", departmentId));
        return mapToDTO(department);

    }

    @Override
    public DepartmentDto updateDepartmentNameById(int departmentId, String departmentName) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", departmentId));

        department.setDepartmentName(departmentName);
        //save updated doctor to DB
        departmentRepository.save(department);
        return mapToDTO(department);

    }

    @Override
    public void deleteDepartmentById(int departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("department: ", "id", departmentId));
        departmentRepository.delete(department);
    }

    private DepartmentDto mapToDTO(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentId(department.getDepartmentId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setNumberOfRooms(department.getNumberOfRooms());
        return departmentDto;
    }

    // convert DTO to entity
    private Department mapToEntity(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setNumberOfRooms(departmentDto.getNumberOfRooms());
        return department;
    }

}
