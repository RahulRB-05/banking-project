package com.example.SenshiProject.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    public class CustomerResponseDTO {

        private Integer customerID;
        private String customerName;
        private int customerAge;
        private String customerEmail;
        private String customerAddress;
        private String  mobileNo;
        private LocalDate dob;
        private LocalDateTime createdAt;
        //    private Customer.CustomerStatus status;
        private String  kycStatus;




        public CustomerResponseDTO(){

            this.createdAt=LocalDateTime.now();
        }


}
