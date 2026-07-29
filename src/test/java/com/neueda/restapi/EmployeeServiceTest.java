package com.neueda.restapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    EmployeeRepository repository;

    @InjectMocks
    EmployeeService service;

    @Test
    void shouldReturnEmployees(){

        List<Employee> list = List.of(

                new Employee("John","IT",50000),

                new Employee("David","HR",60000)

        );
        when(repository.getAllEmployees()).thenReturn(list);
        List<Employee> result =
                service.getAllEmployees();

        assertEquals(2,result.size());

        verify(repository).getAllEmployees();

    }

}