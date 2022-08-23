package com.ironhack.lab402.services;


import com.ironhack.lab402.enums.Department;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.models.Doctor;
import com.ironhack.lab402.models.Patient;
import com.ironhack.lab402.repositories.DoctorRepository;
import com.ironhack.lab402.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    public Patient findById(Long id) {
        if (patientRepository.findById(id).isPresent()) return patientRepository.findById(id).get();
        return null;
    }

    public List<Patient> findByDates(LocalDate start, LocalDate end) {
        System.out.println(start.toString());
        //  return patientRepository.findByDateOfBirthBetween(start, end);
        return patientRepository.findByDates(start, end);
    }

    public List<Patient> findByDoctorDepartment(Department department) {
        //return patientRepository.findByAdmittedByDepartment(department);
        return patientRepository.findByDepartment(department);
    }

    public List<Patient> findByDoctorStatus(Status status) {

        //return patientRepository.findByAdmittedByStatus(status);

        return patientRepository.findByStatus(status);
    }
}
