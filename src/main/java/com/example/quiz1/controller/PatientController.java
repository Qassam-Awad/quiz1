package com.example.quiz1.controller;

import com.example.quiz1.dto.PatientDto;
import com.example.quiz1.service.imp.PatientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Patient")
public class PatientController {

    @Autowired
    private PatientServiceImp patientServiceImp;
    @GetMapping("/list")
    public List<PatientDto> listAllPatient() {
        return patientServiceImp.listAllPatient();
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") int patientId) {
        return new ResponseEntity<>(patientServiceImp.getPatientById(patientId), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<PatientDto> savePatient(@RequestBody PatientDto patientDto) {
        return new ResponseEntity<PatientDto>(patientServiceImp.savePatient(patientDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updateAddressNameById(@PathVariable("id") int patientId, @RequestParam(name="name", required = true) String patientName) {
        return new ResponseEntity<PatientDto>(patientServiceImp.updatePatientNameById(patientId, patientName), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable("id") int patientId) {
        patientServiceImp.deletePatientById(patientId);
        return new ResponseEntity<String>("patient deleted successfully.", HttpStatus.OK);
    }
}
