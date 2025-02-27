package com.bridgelabz.employeepayrollapp.controller;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create Employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Validated @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Validated @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id) ?
                ResponseEntity.ok("Employee deleted successfully!") :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = employeeService.addEmployee(employeeDTO);
        return ResponseEntity.ok(newEmployee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        return (updatedEmployee != null) ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    @PostMapping("/log")
    public ResponseEntity<Employee> addAnEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.info("Received request to add employee: {}", employeeDTO);
        Employee newEmployee = employeeService.addEmployee(employeeDTO);
        return ResponseEntity.ok(newEmployee);
    }

    // Get All Employees
    @GetMapping("/log")
    public ResponseEntity<List<Employee>> getAllemployees() {
        log.info("Received request to fetch all employees.");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Get Employee by ID
    @GetMapping("/{id}/log")
    public ResponseEntity<Optional> getAnEmployeeById(@PathVariable Long id) {
        log.info("Received request to fetch employee with ID: {}", id);
        Optional employee = employeeService.getEmployeeById(id);
        return (employee != null) ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    // Update Employee
    @PutMapping("/{id}/log")
    public ResponseEntity<Employee> updateAnEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        log.info("Received request to update employee with ID: {}", id);
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        return (updatedEmployee != null) ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    // Delete Employee
    @DeleteMapping("/{id}/log")
    public ResponseEntity<Void> deleteAnEmployee(@PathVariable Long id) {
        log.info("Received request to delete employee with ID: {}", id);
        return employeeService.deleteEmployee(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/exceptionhandler")
    public EmployeeDTO getEmployee(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }
    @PostMapping("/add/new")
    public String addAEmployee(@RequestBody EmployeeDTO employeeDTO) {
        long id = new Random().nextLong(1000);
        employeeService.addEmployee((int) id, employeeDTO);
        return "Employee added with ID: " + id;
    }

    @GetMapping("/{id}/new")
    public Optional<Employee> getAEmployee(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add/newlog")
    public String addEmployeee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Received request to add employee: {}", employeeDTO);
        int id = employeeService.addEmployeee(employeeDTO); // Ensure this is valid
        log.info("Employee added successfully with ID: {}", id);
        return "Employee added with ID: " + id;
    }


    @GetMapping("/{id}/newlog")
    public EmployeeDTO getemployee(@PathVariable int id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeService.getEmployeeById(id);
    }

}

