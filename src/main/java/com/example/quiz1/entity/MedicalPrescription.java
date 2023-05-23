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
public class MedicalPrescription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int MPId;

    @Column
    int doctorId;

    @Column
    int patientId;

    @Column
    String description;
}
