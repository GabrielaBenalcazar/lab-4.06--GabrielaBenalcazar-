package com.ironhack.lab4.GabrielaBenalcazar.controller.dto;

import javax.validation.constraints.NotEmpty;

public class EmployeeDepartmentDTO {
    @NotEmpty
    private String department;

    public EmployeeDepartmentDTO() {
    }

    public EmployeeDepartmentDTO(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
