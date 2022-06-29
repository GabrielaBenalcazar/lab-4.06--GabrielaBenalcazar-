package com.ironhack.lab4.GabrielaBenalcazar.repository;

import com.ironhack.lab4.GabrielaBenalcazar.enums.Status;
import com.ironhack.lab4.GabrielaBenalcazar.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long Id);
    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);

}

