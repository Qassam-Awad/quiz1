package com.example.quiz1.controller;

import com.example.quiz1.dto.MedicalPrescriptionDto;
import com.example.quiz1.service.imp.MedicalPrescriptionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/MedicalPrescription")
public class MedicalPrescriptionController {

    @Autowired
    private MedicalPrescriptionServiceImp medicalPrescriptionServiceImp;
    @GetMapping("/list")
    public List<MedicalPrescriptionDto> listAllMedicalPrescription() {
        return medicalPrescriptionServiceImp.listAllMedicalPrescription();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MedicalPrescriptionDto> getMedicalPrescriptionById(@PathVariable("id") int MPId) {
        return new ResponseEntity<>(medicalPrescriptionServiceImp.getMedicalPrescriptionById(MPId), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MedicalPrescriptionDto> saveMedicalPrescription(@RequestBody MedicalPrescriptionDto medicalPrescriptionDto) {
        return new ResponseEntity<MedicalPrescriptionDto>(medicalPrescriptionServiceImp.saveMedicalPrescription(medicalPrescriptionDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MedicalPrescriptionDto> updateMedicalPrescriptionDescriptionById(@PathVariable("id") int MPId, @RequestParam(name="name", required = true) String medicalPrescriptionName) {
        return new ResponseEntity<MedicalPrescriptionDto>(medicalPrescriptionServiceImp.updateMedicalPrescriptionDescriptionById(MPId, medicalPrescriptionName), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicalPrescriptionById(@PathVariable("id") int MPId) {
        medicalPrescriptionServiceImp.deleteMedicalPrescriptionById(MPId);
        return new ResponseEntity<String>("Medical Prescription deleted successfully.", HttpStatus.OK);
    }
}
