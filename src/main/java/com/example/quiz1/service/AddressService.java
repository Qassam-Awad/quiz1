package com.example.quiz1.service;

import com.example.quiz1.dto.AddressDto;
import com.example.quiz1.entity.Address;

import java.util.List;

public interface AddressService {

    AddressDto saveAddress(AddressDto addressDto);

    List<AddressDto> listAllAddress();

    AddressDto getAddressById(int addressId);

    AddressDto updateAddressNameById(int addressId, String addressName);

    void deleteAddressById(int addressId);

   // void addPatientUnderDoctor(int addressId, Patient patient);

    //void dischargePatient(int doctorId, int patientId);
}
