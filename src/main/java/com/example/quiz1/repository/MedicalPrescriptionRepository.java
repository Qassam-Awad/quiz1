package com.example.quiz1.repository;

import com.example.quiz1.entity.MedicalPrescription;
import org.springframework.data.repository.CrudRepository;

public interface MedicalPrescriptionRepository extends CrudRepository<MedicalPrescription, Integer> {
}
