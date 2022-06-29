package com.ironhack.lab4.GabrielaBenalcazar.controller.interfaces;

import com.ironhack.lab4.GabrielaBenalcazar.model.Patient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface PatientController {
    List<Patient> findAll();
    Patient findById(Long Id);
    List<Patient> findByDateOfBirth(String dateOfBirth);
    List<Patient> findByAdmittedByDepartment(String department);
    List<Patient> findByAdmittedByStatusOff();
    Patient store( Patient patient);
    void updateInformation(Long id, Patient patient);
}
