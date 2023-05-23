package com.example.quiz1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int patientId;

    @Column
    String name;

    @Column
    String gender;

    @Column
    String dateOfBirth;

    @Column
    int addressId;

    @Column
    String contactNumber;

    @Column
    String diagnosis;

    @Column
    int roomId;

    @Column
    String admission;

    @Column
    String discharge;

    @Column
    String medicalHistory;
}
