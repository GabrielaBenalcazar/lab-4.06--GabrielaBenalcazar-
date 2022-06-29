package com.ironhack.lab4.GabrielaBenalcazar.service.impl;

import com.ironhack.lab4.GabrielaBenalcazar.enums.Status;
import com.ironhack.lab4.GabrielaBenalcazar.model.Employee;
import com.ironhack.lab4.GabrielaBenalcazar.repository.EmployeeRepository;
import com.ironhack.lab4.GabrielaBenalcazar.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void updateStatus(Long id, Status status) {
        Employee employee =  employeeRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        employee.setStatus(status);
        employeeRepository.save(employee);

    }

    @Override
    public void updateDepartment(Long id, String department) {
        Employee employee =  employeeRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }


}
