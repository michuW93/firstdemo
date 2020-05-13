package com.example.firstdemo.dao;

import com.example.firstdemo.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDao {

    int insertEmployee(UUID id, Employee employee);

    default int insertEmployee(Employee employee){
        UUID id = UUID.randomUUID();
        return insertEmployee(id, employee);
    }

    Optional<Employee> selectEmployeeById(UUID id);

    List<Employee> selectAllEmployees();

    int deleteEmployeeById(UUID id);

    int updateEmployeeById(UUID id, Employee newEmployee);
}
