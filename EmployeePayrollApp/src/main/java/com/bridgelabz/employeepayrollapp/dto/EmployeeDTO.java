package com.bridgelabz.employeepayrollapp.dto;
//lombok library to auto generate getters and setters
import lombok.Data;

@Data
public class EmployeeDTO {
    private String name;
    private double salary;
    private String department;

    public EmployeeDTO() {}

    public EmployeeDTO(String name, double salary,String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Getters and Setters
}
