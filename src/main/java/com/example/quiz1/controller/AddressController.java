package com.example.quiz1.controller;

import com.example.quiz1.dto.AddressDto;
import com.example.quiz1.entity.Address;
import com.example.quiz1.service.imp.AddressServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressServiceImp addressServiceImp;
    @GetMapping("/list")
    public List<AddressDto> listAllAddresses() {
        return addressServiceImp.listAllAddress();
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable("id") int addressId) {
        return new ResponseEntity<>(addressServiceImp.getAddressById(addressId), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<AddressDto> saveAddress(@RequestBody AddressDto addressDto) {
        return new ResponseEntity<AddressDto>(addressServiceImp.saveAddress(addressDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> updateAddressNameById(@PathVariable("id") int doctorId, @RequestParam(name="name", required = true) String addressName) {
        return new ResponseEntity<AddressDto>(addressServiceImp.updateAddressNameById(doctorId, addressName), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable("id") int addressId) {
        addressServiceImp.deleteAddressById(addressId);
        return new ResponseEntity<String>("Address deleted successfully.", HttpStatus.OK);
    }
}
