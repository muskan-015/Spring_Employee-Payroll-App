package com.bridgelabz.employeepayrollapp.dto;
//lombok library to auto generate getters and setters
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
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
    @JsonFormat(pattern = "dd MMM yyyy")  // Converts Date to required format
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be blank")
    private String note;

    @NotBlank(message = "Profile picture URL cannot be blank")
    private String profilePic;

    @NotEmpty(message = "Department cannot be empty")
    private List<String> department;





    // Getters and Setters
}
