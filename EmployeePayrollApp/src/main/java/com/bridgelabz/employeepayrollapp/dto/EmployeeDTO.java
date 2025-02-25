package com.bridgelabz.employeepayrollapp.dto;
//lombok library to auto generate getters and setters
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
@Data
public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty.")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and have at least 3 characters.")
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
