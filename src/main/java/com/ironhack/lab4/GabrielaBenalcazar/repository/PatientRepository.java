package com.ironhack.lab4.GabrielaBenalcazar.repository;

import com.ironhack.lab4.GabrielaBenalcazar.enums.Status;
import com.ironhack.lab4.GabrielaBenalcazar.model.Employee;
import com.ironhack.lab4.GabrielaBenalcazar.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findById(Long id );
    List<Patient> findByDateOfBirth(String dateOfBirth);
    @Query("SELECT p FROM Patient p LEFT JOIN  p.admittedBy e where e.department=:department")
    List<Patient> findByAdmittedByDepartment(String department);
    @Query("SELECT p FROM Patient p LEFT JOIN  p.admittedBy e where e.status = OFF")
    List<Patient> findByAdmittedByStatusOff();

}

