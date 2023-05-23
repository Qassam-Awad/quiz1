package com.example.quiz1.service;

import com.example.quiz1.dto.AddressDto;
import com.example.quiz1.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> listAllDepartment();

    DepartmentDto getDepartmentById(int departmentId);

    DepartmentDto updateDepartmentNameById(int departmentId, String departmentName);

    void deleteDepartmentById(int departmentId);
}
