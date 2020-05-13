package com.example.firstdemo.api;

import com.example.firstdemo.model.Employee;
import com.example.firstdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void addEmployee(@Valid @NotNull @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmplyees() {
        return employeeService.selectAllEmployees();
    }

    @GetMapping(path = "{id}")
    public Employee getEmployeeByid(@PathVariable("id") UUID id) {
        return employeeService.selectEmployeeById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployeeById(@PathVariable("id") UUID id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "{id}")
    public int updateEmployee(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Employee newEmployee) {
        return employeeService.updateEmployee(id, newEmployee);
    }
}
