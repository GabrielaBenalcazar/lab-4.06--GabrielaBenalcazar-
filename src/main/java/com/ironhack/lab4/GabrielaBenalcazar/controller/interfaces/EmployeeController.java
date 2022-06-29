package com.ironhack.lab4.GabrielaBenalcazar.controller.interfaces;

import com.ironhack.lab4.GabrielaBenalcazar.controller.dto.EmployeeDepartmentDTO;
import com.ironhack.lab4.GabrielaBenalcazar.controller.dto.EmployeeStatusDTO;
import com.ironhack.lab4.GabrielaBenalcazar.enums.Status;
import com.ironhack.lab4.GabrielaBenalcazar.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface EmployeeController {
    List<Employee> findAll();
    Employee findById(Long Id);
    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);

    Employee store( Employee employee);

    void updateStatus(Long id, EmployeeStatusDTO employeeStatusDTO);
    void updateDepartment(Long id, EmployeeDepartmentDTO employeeDepartmentDTO);
}
