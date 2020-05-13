package com.example.firstdemo.dao;

import com.example.firstdemo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EmployeeDataAccessService implements EmployeeDao {
    private static List<Employee> DB = new ArrayList<>(); //DB mock as List

    @Override
    public int insertEmployee(UUID id, Employee employee) {
        DB.add(new Employee(id, employee.getName()));
        return 1;
    }

    @Override
    public int insertEmployee(Employee employee) {
        return insertEmployee(UUID.randomUUID(), employee);
    }

    @Override
    public Optional<Employee> selectEmployeeById(UUID id) {
        return DB.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return this.DB;
    }

    @Override
    public int deleteEmployeeById(UUID id) {
        Optional<Employee> employee = selectEmployeeById(id);
        if (employee.isPresent()) {
            DB.remove(employee.get());
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateEmployeeById(UUID id, Employee newEmployee) {
        return selectEmployeeById(id)
                .map(employee -> {
                    int employeeIndex = DB.indexOf(employee);
                    if (employeeIndex >= 0) {
                        DB.set(employeeIndex, new Employee(id, newEmployee.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
