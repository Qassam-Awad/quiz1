package com.example.quiz1.dto;

import lombok.Data;

@Data
public class PatientDto {
    int patientId;

    String name;
    String gender;
    String dateOfBirth;
    int addressId;
    String contactNumber;
    String diagnosis;
    int roomId;
    String admission;
    String discharge;
    String medicalHistory;
}
