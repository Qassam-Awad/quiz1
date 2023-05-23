package com.example.quiz1.service.imp;

import com.example.quiz1.dto.AddressDto;
import com.example.quiz1.dto.DoctorDto;
import com.example.quiz1.entity.Address;
import com.example.quiz1.entity.Department;
import com.example.quiz1.entity.Doctor;
import com.example.quiz1.exeption.ResourceNotFoundException;
import com.example.quiz1.repository.AddressRepository;
import com.example.quiz1.repository.DoctorRepository;
import com.example.quiz1.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImp implements DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorServiceImp(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorDto saveDoctor(DoctorDto doctorDto) {

        // convert DTO to entity
        Doctor doctor = mapToEntity(doctorDto);
        Doctor newDoctor = doctorRepository.save(doctor);

        // convert entity to DTO
        return mapToDTO(newDoctor);

    }

    @Override
    public List<DoctorDto> listAllDoctor() {
        List<Doctor> doctors = new ArrayList<>();

        doctorRepository.findAll().forEach(doctors::add);
        return doctors.stream().map(this::mapToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public DoctorDto getDoctorById(int doctorId) {

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("doctor: ", "id", doctorId));
        return mapToDTO(doctor);
    }

    @Override
    public DoctorDto updateDoctorNameById(int doctorId, String doctorName) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));

        doctor.setName(doctorName);
        //save updated doctor to DB
        doctorRepository.save(doctor);
        return mapToDTO(doctor);


    }

    @Override
    public void deleteDoctorById(int doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor: ", "id", doctorId));
        doctorRepository.delete(doctor);
    }

    private DoctorDto mapToDTO(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setDoctorId(doctor.getDoctorId());
        doctorDto.setName(doctor.getName());
        doctorDto.setDateOfBirth(doctor.getDateOfBirth());
        doctorDto.setAddressId(doctor.getAddressId());
        doctorDto.setContactNumber(doctor.getContactNumber());
        doctorDto.setDepartmentId(doctor.getDepartmentId());

        return doctorDto;
    }

    // convert DTO to entity
    private Doctor mapToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorDto.getDoctorId());
        doctor.setName(doctorDto.getName());
        doctor.setDateOfBirth(doctorDto.getDateOfBirth());
        doctor.setAddressId(doctorDto.getAddressId());
        doctor.setContactNumber(doctorDto.getContactNumber());
        doctor.setDepartmentId(doctorDto.getDepartmentId());

        return doctor;
    }

}
