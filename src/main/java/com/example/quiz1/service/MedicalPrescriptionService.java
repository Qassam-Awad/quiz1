package com.example.quiz1.service;

import com.example.quiz1.dto.MedicalPrescriptionDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface MedicalPrescriptionService {
    MedicalPrescriptionDto saveMedicalPrescription(MedicalPrescriptionDto medicalPrescriptionDto);

    List<MedicalPrescriptionDto> listAllMedicalPrescription();

    MedicalPrescriptionDto getMedicalPrescriptionById(int medicalPrescriptionId);

    MedicalPrescriptionDto updateMedicalPrescriptionDescriptionById(int medicalPrescriptionId, String medicalPrescriptionName);

    void deleteMedicalPrescriptionById(int medicalPrescriptionId);
}
