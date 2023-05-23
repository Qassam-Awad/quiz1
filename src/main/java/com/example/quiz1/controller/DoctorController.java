package com.example.quiz1.controller;

import com.example.quiz1.dto.DepartmentDto;
import com.example.quiz1.dto.DoctorDto;
import com.example.quiz1.service.imp.DoctorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/api/Doctor")
public class DoctorController {
    @Autowired
    private DoctorServiceImp doctorServiceImp;
    @GetMapping("/list")
    public List<DoctorDto> listAllDoctors() {
        return doctorServiceImp.listAllDoctor();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable("id") int doctorId) {
        return new ResponseEntity<>(doctorServiceImp.getDoctorById(doctorId), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DoctorDto> saveAddress(@RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<DoctorDto>(doctorServiceImp.saveDoctor(doctorDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateAddressNameById(@PathVariable("id") int doctorId, @RequestParam(name="name", required = true) String doctorName) {
        return new ResponseEntity<DoctorDto>(doctorServiceImp.updateDoctorNameById(doctorId, doctorName), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable("id") int doctorId) {
        doctorServiceImp.deleteDoctorById(doctorId);
        return new ResponseEntity<String>("Address deleted successfully.", HttpStatus.OK);
    }
}
