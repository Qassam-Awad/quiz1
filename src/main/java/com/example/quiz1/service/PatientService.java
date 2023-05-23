package com.example.quiz1.service;

import com.example.quiz1.dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto savePatient(PatientDto patientDto);

    List<PatientDto> listAllPatient();

    PatientDto getPatientById(int patientId);

    PatientDto updatePatientNameById(int patientId, String patientName);

    void deletePatientById(int patientId);
}
