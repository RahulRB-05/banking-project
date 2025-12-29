package com.example.SenshiProject.entity;

<<<<<<< HEAD
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

        private Integer customerID;

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
=======
import jakarta.persistence.Entity;


public class Customer {
}
>>>>>>> origin/developer1
