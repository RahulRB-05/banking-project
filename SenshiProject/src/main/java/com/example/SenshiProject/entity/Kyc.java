package com.example.SenshiProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Table(name="kycDetails",

            uniqueConstraints = {
                    @UniqueConstraint(columnNames = "aadhaarNo"),
                    @UniqueConstraint(columnNames = "panNo")
            }
    )

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Kyc {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer kycId;

        private String  aadhaarNo;
        private String  panNo;

        @Enumerated(EnumType.STRING)
        private KycStatus kycStatus;


        @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)

        @JoinColumn(name="customer_id")
        private Customer customerDetails;


        public enum KycStatus{

            PENDING,
            APPROVED,
            REJECTED;

        }








    }
