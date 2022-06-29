package com.ironhack.lab4.GabrielaBenalcazar.controller.impl;

import com.ironhack.lab4.GabrielaBenalcazar.controller.dto.EmployeeDepartmentDTO;
import com.ironhack.lab4.GabrielaBenalcazar.controller.dto.EmployeeStatusDTO;
import com.ironhack.lab4.GabrielaBenalcazar.controller.interfaces.EmployeeController;
import com.ironhack.lab4.GabrielaBenalcazar.enums.Status;
import com.ironhack.lab4.GabrielaBenalcazar.model.Employee;
import com.ironhack.lab4.GabrielaBenalcazar.model.Patient;
import com.ironhack.lab4.GabrielaBenalcazar.repository.EmployeeRepository;
import com.ironhack.lab4.GabrielaBenalcazar.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all-doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/doctor/by-id/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findById(@PathVariable Long Id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(Id);
        return optionalEmployee.get();
    }

    @GetMapping("/doctor/by-status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findByStatus(@PathVariable Status status) {
        return employeeRepository.findByStatus(status);
    }

    @GetMapping("/doctor/by-department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findByDepartment(@PathVariable String department) {
        return employeeRepository.findByDepartment(department);
    }

    //Create a route to add a new doctor.

    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee store(@RequestBody @Valid Employee employee) {
        return employeeRepository.save(employee);
    }
    //Create a route to change a doctor’s status.

    @PatchMapping("/doctors/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Long id, @RequestBody @Valid EmployeeStatusDTO employeeStatusDTO) {
        employeeService.updateStatus(id, employeeStatusDTO.getStatus());

}
    //Create a route to update a doctor’s department.

    @PatchMapping("/doctors/{id}/department")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment(@PathVariable Long id, @RequestBody @Valid EmployeeDepartmentDTO employeeDepartmentDTO) {
        employeeService.updateDepartment(id, employeeDepartmentDTO.getDepartment());

    }

}
