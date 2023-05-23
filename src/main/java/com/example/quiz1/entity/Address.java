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
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int addressId;

    @Column
    String addressName;

    @Column
    String streetName;

    @Column
    String city;

    @Column
    String state;

    @Column
    String country;

    @Column
    String postalCode;
}
