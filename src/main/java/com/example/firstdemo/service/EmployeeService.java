package com.example.firstdemo.service;

import com.example.firstdemo.dao.EmployeeDao;
import com.example.firstdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int addEmployee(Employee employee){
        return employeeDao.insertEmployee(employee);
    }

    public List<Employee> selectAllEmployees(){
        return employeeDao.selectAllEmployees();
    }

    public Optional<Employee> selectEmployeeById(UUID id){
        return employeeDao.selectEmployeeById(id);
    }

    public int deleteEmployee(UUID id){
        return employeeDao.deleteEmployeeById(id);
    }

    public int updateEmployee(UUID id, Employee newEmployee){
        return employeeDao.updateEmployeeById(id, newEmployee);
    }
}
