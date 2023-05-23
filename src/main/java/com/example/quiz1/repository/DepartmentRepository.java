package com.example.quiz1.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.quiz1.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{
}
