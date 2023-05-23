package com.example.quiz1.dto;

import lombok.Data;
@Data
public class AddressDto {
    int addressId;
    String addressName;
    String streetName;
    String city;
    String state;
    String country;
    String postalCode;

}
