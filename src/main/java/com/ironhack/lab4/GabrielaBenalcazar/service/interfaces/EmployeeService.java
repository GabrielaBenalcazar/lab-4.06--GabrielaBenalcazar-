package com.ironhack.lab4.GabrielaBenalcazar.service.interfaces;

import com.ironhack.lab4.GabrielaBenalcazar.controller.dto.EmployeeDepartmentDTO;
import com.ironhack.lab4.GabrielaBenalcazar.controller.dto.EmployeeStatusDTO;
import com.ironhack.lab4.GabrielaBenalcazar.enums.Status;

public interface EmployeeService {
    void updateStatus (Long id, Status status);
    void updateDepartment(Long id,String department);
}
