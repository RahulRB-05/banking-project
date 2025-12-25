package com.example.SenshiProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_id;
    private Long accountNumber;
    private String holderName;
    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private LocalDateTime createdDate;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public enum AccountStatus{
        ACTIVE,
        FROZEN,
        CLOSED
    }

    @PrePersist
    public void onCreate(){

        this.createdDate=LocalDateTime.now();
        this.status = AccountStatus.ACTIVE;
    }
}
