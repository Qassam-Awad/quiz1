package com.example.quiz1.service.imp;

import com.example.quiz1.dto.AddressDto;
import com.example.quiz1.entity.Address;
import com.example.quiz1.exeption.ResourceNotFoundException;
import com.example.quiz1.repository.AddressRepository;
import com.example.quiz1.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImp(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDto saveAddress(AddressDto addressDto) {
        // convert DTO to entity
        Address address = mapToEntity(addressDto);
        Address newAddress = addressRepository.save(address);

        // convert entity to DTO
        return mapToDTO(newAddress);
    }

    @Override
    public List<AddressDto> listAllAddress() {
        List<Address> addresses = new ArrayList<>();

        addressRepository.findAll().forEach(addresses::add);
        return addresses.stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto getAddressById(int addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("address: ", "id", addressId));
        return mapToDTO(address);
    }

    @Override
    public AddressDto updateAddressNameById(int addressId, String addressName) {

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address: ", "Id", addressId));

        address.setAddressName(addressName);
        //save updated address to DB
        addressRepository.save(address);
        return mapToDTO(address);

//        Address address = addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", addressId));
//
//        address.setAddressId(addressDto.getAddressId());
//        address.setAddressName(addressDto.getAddressName());
//        address.setStreetName(addressDto.getStreetName());
//        address.setCity(addressDto.getCity());
//        address.setCountry(addressDto.getCountry());
//        address.setState(addressDto.getState());
//        address.setPostalCode(addressDto.getPostalCode());
//
//        Category updatedCategory = categoryRepository.save(category);
//        return mapToDTO(updatedCategory);
    }

    @Override
    public void deleteAddressById(int addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", addressId));
        addressRepository.delete(address);
    }

    private AddressDto mapToDTO(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddressId(address.getAddressId());
        addressDto.setAddressName(address.getAddressName());
        addressDto.setStreetName(address.getStreetName());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        addressDto.setState(address.getState());
        addressDto.setPostalCode(address.getPostalCode());


        return addressDto;
    }

    // convert DTO to entity
    private Address mapToEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setAddressId(addressDto.getAddressId());
        address.setAddressName(addressDto.getAddressName());
        address.setStreetName(addressDto.getStreetName());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setState(addressDto.getState());
        address.setPostalCode(addressDto.getPostalCode());

        return address;
    }
}
