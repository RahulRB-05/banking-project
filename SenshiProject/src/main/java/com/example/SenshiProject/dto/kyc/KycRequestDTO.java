package com.example.SenshiProject.dto.kyc;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data

    public class KycRequestDTO
    {
        @NotBlank(message = "AadhaarNumber is mandatory for kyc verification")
        @Pattern(regexp = "^[2-9]{1}[0-9]{11}$",message = "Invaild Aadhar number")
        private String aadhaarNo;


        @NotBlank(message = "AadhaarNumber is mandatory for kyc verification")
        @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$",message = "Invaild Pan number")
        private String panNo;


    }
