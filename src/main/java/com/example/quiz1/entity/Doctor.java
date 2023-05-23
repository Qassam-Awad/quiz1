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
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int doctorId;

    @Column
    String name;

    @Column
    String dateOfBirth;

    @Column
    int addressId;

    @Column
    String contactNumber;

    @Column
    int departmentId;

}
