package com.example.quiz1.service.imp;

import com.example.quiz1.dto.PatientDto;
import com.example.quiz1.dto.RoomDto;
import com.example.quiz1.entity.Patient;
import com.example.quiz1.entity.Room;
import com.example.quiz1.exeption.ResourceNotFoundException;
import com.example.quiz1.repository.PatientRepository;
import com.example.quiz1.repository.RoomRepository;
import com.example.quiz1.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImp implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImp(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto savePatient(PatientDto patientDto) {

        // convert DTO to entity
        Patient patient = mapToEntity(patientDto);
        Patient newPatient = patientRepository.save(patient);

        // convert entity to DTO
        return mapToDTO(newPatient);

    }

    @Override
    public List<PatientDto> listAllPatient() {

        List<Patient> patients = new ArrayList<>();

        patientRepository.findAll().forEach(patients::add);
        return patients.stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatientById(int patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("patient: ", "id", patientId));
        return mapToDTO(patient);
    }


    @Override
    public PatientDto updatePatientNameById(int patientId, String patientName) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("patient: ", "Id", patientId));

        patient.setName(patientName);
        //save updated address to DB
        patientRepository.save(patient);
        return mapToDTO(patient);
    }

    @Override
    public void deletePatientById(int patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("patient: ", "id", patientId));
        patientRepository.delete(patient);
    }

    private PatientDto mapToDTO(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setPatientId(patient.getPatientId());
        patientDto.setName(patient.getName());
        patientDto.setGender(patient.getGender());
        patientDto.setDateOfBirth(patient.getDateOfBirth());
        patientDto.setAddressId(patient.getAddressId());
        patientDto.setContactNumber(patient.getContactNumber());
        patientDto.setDiagnosis(patient.getDiagnosis());
        patientDto.setRoomId(patient.getRoomId());
        patientDto.setAdmission(patient.getAdmission());
        patientDto.setDischarge(patient.getDischarge());
        patientDto.setMedicalHistory(patient.getMedicalHistory());
        return patientDto;
    }

    // convert DTO to entity
    private Patient mapToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setPatientId(patientDto.getPatientId());
        patient.setName(patientDto.getName());
        patient.setGender(patientDto.getGender());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setAddressId(patientDto.getAddressId());
        patient.setContactNumber(patientDto.getContactNumber());
        patient.setDiagnosis(patientDto.getDiagnosis());
        patient.setRoomId(patientDto.getRoomId());
        patient.setAdmission(patientDto.getAdmission());
        patient.setDischarge(patientDto.getDischarge());
        patient.setMedicalHistory(patientDto.getMedicalHistory());
        return patient;
    }
}
