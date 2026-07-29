package com.neueda.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get All Employees
    public List<Employee> getAllEmployees() {

        String sql = "SELECT * FROM employee";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Employee.class));
    }

    // Get Employee By Id
    public Employee getEmployeeById(int id) {

        String sql = "SELECT * FROM employee WHERE id=?";

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<>(Employee.class),
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }

    }

    // Insert Employee
    public Employee addEmployee(Employee employee) {

        String sql = "INSERT INTO employee(name, department, salary) VALUES(?,?,?)";

        int result = jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getDepartment(),
                employee.getSalary());

        if (result > 0) {
            return employee;
        } else {
            return null;
        }
    }

    // Update Employee
    public Employee updateEmployee(int id, Employee employee) {

        String sql =
                "UPDATE employee SET name=?, department=?, salary=? WHERE id=?";

        int result = jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getDepartment(),
                employee.getSalary(),
                id);

        if (result > 0) {
            return employee;
        } else {
            return null;
        }
    }

    // Delete Employee
    public Employee deleteEmployee(int id) {

        String sql = "DELETE FROM employee WHERE id=?";

        int result = jdbcTemplate.update(sql, id);

        if (result > 0) {
            return new Employee(null, null, 0); // Return a dummy employee with only the ID set
        } else {
            return null;
        }
    }
}