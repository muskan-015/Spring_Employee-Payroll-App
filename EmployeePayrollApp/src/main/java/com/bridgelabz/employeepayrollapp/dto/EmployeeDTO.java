package com.bridgelabz.employeepayrollapp.dto;
//lombok library to auto generate getters and setters
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty.")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and have at least 3 characters.")
    private String name;
    private double salary;
    //private String department;
    @NotEmpty(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Start date is required")
    @PastOrPresent(message = "Start date should not be a future date")
    private LocalDate startDate;

    private String note;

    private String profilePic;

    @NotEmpty(message = "Department cannot be empty")
    private List<String> department;





    // Getters and Setters
}
