package com.ironhack.lab402.services;

import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.models.Doctor;
import com.ironhack.lab402.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctor() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctorById(Long id) {
        if (doctorRepository.findById(id).isPresent()) return doctorRepository.findById(id).get();
        return null;
    }

    public List<Doctor> findDoctorsByStatus(Status status) {
        return doctorRepository.findByStatus(status);
    }

    public List<Doctor> findDoctorsByDepartment(Department department) {
        return doctorRepository.findByDepartment(department);
    }


}
