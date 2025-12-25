package com.example.SenshiProject.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;


    @AllArgsConstructor
    @Data
    public class UpdateCustomerDetailsDTO {


        private String customerName;
        private String customerEmail;
        private String customerAddress;
        private String  mobileNo;



    }
