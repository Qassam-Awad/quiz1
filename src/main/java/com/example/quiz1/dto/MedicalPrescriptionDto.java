package com.example.quiz1.dto;

import lombok.Data;

@Data
public class MedicalPrescriptionDto {

    int MPId;
    int doctorId;
    int patientId;
    String description;
}
