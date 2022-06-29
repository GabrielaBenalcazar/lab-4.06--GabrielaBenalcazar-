package com.ironhack.lab4.GabrielaBenalcazar.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.lab4.GabrielaBenalcazar.enums.Status;
import com.ironhack.lab4.GabrielaBenalcazar.model.Employee;
import com.ironhack.lab4.GabrielaBenalcazar.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class EmployeeControllerImplTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Employee employee1,employee2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        employee1 = new Employee("orthopaedic","Paolo Rodriguez", Status.ON_CALL);
        employee2 = new Employee("pulmonary","Maria Lin", Status.ON);
        employeeRepository.saveAll(List.of(employee1,employee2));
    }

    @AfterEach
        void tearDown() {
            employeeRepository.deleteAll();
        }



    @Test
    void findAll_NoParams_AllEmployees() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/all-doctors"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("orthopaedic"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("pulmonary"));



    }

    @Test
    void findById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/doctor/by-id/"+employee1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


        assertTrue(mvcResult.getResponse().getContentAsString().contains("Paolo Rodriguez"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Maria Lin"));
    }


    @Test
    void findByStatus() {
    }

    @Test
    void findByDepartment() {
    }

    @Test
    void store() {
    }

    @Test
    void updateStatus() {
    }

    @Test
    void updateDepartment() {
    }
}