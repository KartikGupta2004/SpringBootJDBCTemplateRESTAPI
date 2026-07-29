package com.neueda.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService  {

    @Autowired
    EmployeeRepository repository;


    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }


    public Employee getEmployeeById(int id) {

        Employee employee = repository.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        return employee;
    }


       public int saveEmployee(Employee employee) {
        return repository.addEmployee(employee) != null ? 1 : 0;
    }


    public int updateEmployee(int id, Employee employee) {
        return repository.updateEmployee(id, employee) != null ? 1 : 0;
    }


    public int deleteEmployee(int id) {
        return repository.deleteEmployee(id) != null ? 1 : 0;
    }
}