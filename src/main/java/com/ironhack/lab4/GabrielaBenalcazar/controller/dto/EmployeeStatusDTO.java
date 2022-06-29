package com.ironhack.lab4.GabrielaBenalcazar.controller.dto;

import com.ironhack.lab4.GabrielaBenalcazar.enums.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class EmployeeStatusDTO {
    @Enumerated(EnumType.STRING)
    private Status status;

    public EmployeeStatusDTO() {
    }
    public EmployeeStatusDTO(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
