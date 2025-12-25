package com.example.SenshiProject.dto.customer;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


    @AllArgsConstructor
    @Data

    public class CustomerRequestDTO {

        @NotBlank(message = "name should be given")
        private String  customerName;

        @NotNull
        @Min(value = 10, message = "AccountHolder should be mininum 10 old")
        private int   customerAge;
        @Email(message="invalid email")
        @NotBlank(message="Email is mandatory")
        private String customerEmail;
        @NotBlank(message = "Address is mandatory")
        private String customerAddress;

        @NotBlank(message="MobileNumber is mandatory")
        @Size(min=10,max=10,message = "Kindly provide valid mobile number")
        private String mobileNo;
        @Past(message = "Date of Birth can be in future make sure dob is valid")
        private LocalDate dob;
        private LocalDateTime createdAt;





    }
