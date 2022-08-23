package com.ironhack.lab402.controller;

import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.models.Doctor;
import com.ironhack.lab402.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("doctor/find-all")
    public List<Doctor> findAll() {
        return doctorService.findAllDoctor();
    }

    @GetMapping("doctor/find-by-id")
    public Doctor findById(@RequestParam Long id) {
        return doctorService.findDoctorById(id);
    }

    @GetMapping("doctor/find-by-status/{status}")
    public List<Doctor> findByStatus(@PathVariable Status status) {
        return doctorService.findDoctorsByStatus(status);
    }

    @GetMapping("doctor/find-by-department/{department}")
    public List<Doctor> findByStatus(@PathVariable Department department) {
        return doctorService.findDoctorsByDepartment(department);
    }
}
