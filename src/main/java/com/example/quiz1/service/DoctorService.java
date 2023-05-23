package com.example.quiz1.service;

import com.example.quiz1.dto.DoctorDto;
import com.example.quiz1.entity.Doctor;

import java.util.List;

public interface DoctorService {
    DoctorDto saveDoctor(DoctorDto doctorDto);

    List<DoctorDto> listAllDoctor();

    DoctorDto getDoctorById(int doctorId);

    DoctorDto updateDoctorNameById(int doctorId, String doctorName);

    void deleteDoctorById(int doctorId);
}
