package com.ironhack.lab4.GabrielaBenalcazar.service.impl;

import com.ironhack.lab4.GabrielaBenalcazar.model.Employee;
import com.ironhack.lab4.GabrielaBenalcazar.model.Patient;
import com.ironhack.lab4.GabrielaBenalcazar.repository.PatientRepository;
import com.ironhack.lab4.GabrielaBenalcazar.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public void updateInformation(Long id, Patient patient) {
        Patient patientSer  =  patientRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "patient not found"));
        patientSer.setId(id);
        patientRepository.save(patientSer);
    }
}
