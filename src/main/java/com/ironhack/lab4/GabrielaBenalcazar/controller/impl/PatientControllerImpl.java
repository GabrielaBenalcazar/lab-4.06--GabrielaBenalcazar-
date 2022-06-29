package com.ironhack.lab4.GabrielaBenalcazar.controller.impl;

import com.ironhack.lab4.GabrielaBenalcazar.controller.interfaces.PatientController;
import com.ironhack.lab4.GabrielaBenalcazar.model.Patient;
import com.ironhack.lab4.GabrielaBenalcazar.repository.EmployeeRepository;
import com.ironhack.lab4.GabrielaBenalcazar.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientControllerImpl implements PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/all-patients")
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/by-id/{Id}")
    public Patient findById(@PathVariable Long Id) {
        Optional<Patient> optionalPatient = patientRepository.findById(Id);

        return optionalPatient.get();
    }

    @GetMapping("/patient/by-birth-date/{date_of_birth}")
    public List<Patient> findByDateOfBirth(@PathVariable  String date_of_birth) {
        return patientRepository.findByDateOfBirth(date_of_birth);
    }

    @GetMapping("/patient/by-doctor-by.department/{department}")
    public List<Patient> findByAdmittedByDepartment( @PathVariable  String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/patient/by-doctor-status-off")
    public List<Patient> findByAdmittedByStatusOff() {
        return patientRepository.findByAdmittedByStatusOff();
    }
 // Create a route to add a new patient.
    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient store(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    //Create a route to update patient’s information (the user should be able to update any patient information through this route).
    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInformation(@PathVariable Long id, @RequestBody @Valid Patient patient) {
//        patientService.renovate(patientId, patient);
    }




}
