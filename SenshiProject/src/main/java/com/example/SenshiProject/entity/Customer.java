package com.example.SenshiProject.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

    @Table(name="customerDetails")
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Data

    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Integer customerId;

        private String  customerName;
        private int   customerAge;
        private String customerEmail;
        private String customerAddress;
        private String mobileNo;
        private LocalDate dob;
        private LocalDateTime createdAt;



        @OneToOne(mappedBy ="customerDetails",cascade = CascadeType.ALL)
        private Kyc kycVerificationForm;











    }

