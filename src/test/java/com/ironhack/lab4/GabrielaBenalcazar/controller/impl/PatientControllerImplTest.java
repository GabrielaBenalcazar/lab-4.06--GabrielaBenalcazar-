package com.ironhack.lab4.GabrielaBenalcazar.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.lab4.GabrielaBenalcazar.repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientControllerImplTest {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByDateOfBirth() {
    }

    @Test
    void findByAdmittedByDepartment() {
    }

    @Test
    void findByAdmittedByStatusOff() {
    }

    @Test
    void store() {
    }

    @Test
    void updateInformation() {
    }
}