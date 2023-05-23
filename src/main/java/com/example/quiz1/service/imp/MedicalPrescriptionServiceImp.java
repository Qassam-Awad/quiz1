package com.example.quiz1.service.imp;

import com.example.quiz1.dto.DoctorDto;
import com.example.quiz1.dto.MedicalPrescriptionDto;
import com.example.quiz1.entity.Address;
import com.example.quiz1.entity.Doctor;
import com.example.quiz1.entity.MedicalPrescription;
import com.example.quiz1.exeption.ResourceNotFoundException;
import com.example.quiz1.repository.DoctorRepository;
import com.example.quiz1.repository.MedicalPrescriptionRepository;
import com.example.quiz1.service.MedicalPrescriptionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalPrescriptionServiceImp implements MedicalPrescriptionService {
    private final MedicalPrescriptionRepository medicalPrescriptionRepository;

    public MedicalPrescriptionServiceImp(MedicalPrescriptionRepository medicalPrescriptionRepository) {
        this.medicalPrescriptionRepository = medicalPrescriptionRepository;
    }

    @Override
    public MedicalPrescriptionDto saveMedicalPrescription(MedicalPrescriptionDto medicalPrescriptionDto) {

        // convert DTO to entity
        MedicalPrescription medicalPrescription = mapToEntity(medicalPrescriptionDto);
        MedicalPrescription newMedicalPrescription = medicalPrescriptionRepository.save(medicalPrescription);

        // convert entity to DTO
        return mapToDTO(newMedicalPrescription);

    }

    @Override
    public List<MedicalPrescriptionDto> listAllMedicalPrescription() {
        List<MedicalPrescription> medicalPrescriptions = new ArrayList<>();

        medicalPrescriptionRepository.findAll().forEach(medicalPrescriptions::add);
        return medicalPrescriptions.stream().map(this::mapToDTO)
                .collect(Collectors.toList());


    }

    @Override
    public MedicalPrescriptionDto getMedicalPrescriptionById(int medicalPrescriptionId) {
        MedicalPrescription medicalPrescription = medicalPrescriptionRepository.findById(medicalPrescriptionId).orElseThrow(() -> new ResourceNotFoundException("medicalPrescription: ", "id", medicalPrescriptionId));
        return mapToDTO(medicalPrescription);


    }

    @Override
    public MedicalPrescriptionDto updateMedicalPrescriptionDescriptionById(int medicalPrescriptionId, String medicalPrescriptionDescription) {
        MedicalPrescription medicalPrescription = medicalPrescriptionRepository.findById(medicalPrescriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("medicalPrescription: ", "Id", medicalPrescriptionId));

        medicalPrescription.setDescription(medicalPrescriptionDescription);
        medicalPrescriptionRepository.save(medicalPrescription);
        return mapToDTO(medicalPrescription);
    }

    @Override
    public void deleteMedicalPrescriptionById(int medicalPrescriptionId) {
        MedicalPrescription medicalPrescription = medicalPrescriptionRepository.findById(medicalPrescriptionId).orElseThrow(() -> new ResourceNotFoundException("MedicalPrescription: ", "id", medicalPrescriptionId));
        medicalPrescriptionRepository.delete(medicalPrescription);
    }

    private MedicalPrescriptionDto mapToDTO(MedicalPrescription medicalPrescription) {
        MedicalPrescriptionDto medicalPrescriptionDto = new MedicalPrescriptionDto();
        medicalPrescriptionDto.setMPId(medicalPrescription.getMPId());
        medicalPrescriptionDto.setDoctorId(medicalPrescription.getDoctorId());
        medicalPrescriptionDto.setPatientId(medicalPrescription.getPatientId());
        medicalPrescriptionDto.setDescription(medicalPrescription.getDescription());

        return medicalPrescriptionDto;
    }

    // convert DTO to entity
    private MedicalPrescription mapToEntity(MedicalPrescriptionDto medicalPrescriptionDto) {
        MedicalPrescription medicalPrescription = new MedicalPrescription();
        medicalPrescription.setMPId(medicalPrescriptionDto.getMPId());
        medicalPrescription.setDoctorId(medicalPrescriptionDto.getDoctorId());
        medicalPrescription.setPatientId(medicalPrescriptionDto.getPatientId());
        medicalPrescription.setDescription(medicalPrescriptionDto.getDescription());

        return medicalPrescription;
    }
}
