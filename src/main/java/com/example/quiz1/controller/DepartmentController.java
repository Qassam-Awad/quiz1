package com.example.quiz1.controller;

import com.example.quiz1.dto.AddressDto;
import com.example.quiz1.dto.DepartmentDto;
import com.example.quiz1.service.imp.AddressServiceImp;
import com.example.quiz1.service.imp.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImp departmentServiceImp;
    @GetMapping("/list")
    public List<DepartmentDto> listAllDepartments() {
        return departmentServiceImp.listAllDepartment();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") int departmentId) {
        return new ResponseEntity<>(departmentServiceImp.getDepartmentById(departmentId), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<DepartmentDto>(departmentServiceImp.saveDepartment(departmentDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateAddressNameById(@PathVariable("id") int departmentId, @RequestParam(name="name", required = true) String departmentName) {
        return new ResponseEntity<DepartmentDto>(departmentServiceImp.updateDepartmentNameById(departmentId, departmentName), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") int departmentId) {
        departmentServiceImp.deleteDepartmentById(departmentId);
        return new ResponseEntity<String>("Address deleted successfully.", HttpStatus.OK);
    }
}
