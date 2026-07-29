package com.neueda.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jdbc.test.autoconfigure.DataJdbcTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureDataSourceInitialization;
import org.springframework.context.annotation.Import;

import java.util.List;
import  org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@Import(EmployeeRepository.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepoTesting {
    @Autowired
    EmployeeRepository repository;

    @Test
    void shouldReturnEmployees(){

        List<Employee> employees =
                repository.getAllEmployees();

        assertFalse(employees.isEmpty());

    }
}

