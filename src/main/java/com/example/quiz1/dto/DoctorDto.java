package com.example.quiz1.dto;

import lombok.Data;

@Data
public class DoctorDto {

    int doctorId;
    String name;
    String dateOfBirth;
    int addressId;
    String contactNumber;
    int departmentId;
}
