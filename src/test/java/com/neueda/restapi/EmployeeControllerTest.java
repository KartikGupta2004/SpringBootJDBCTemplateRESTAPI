package com.neueda.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    EmployeeService service;

    @Test
    void shouldReturnEmployees() throws Exception {

        List<Employee> list = List.of(

                new Employee("John","IT",50000)

        );

        when(service.getAllEmployees())
                .thenReturn(list);

        // fix this

        mockMvc.perform(get("/employees"))

                .andExpect(status().isOk())

                .andExpect(jsonPath("$.data[0].name").value("John"));

    }

}