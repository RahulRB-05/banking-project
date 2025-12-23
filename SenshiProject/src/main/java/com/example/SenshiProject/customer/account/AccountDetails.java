package com.example.SenshiProject.customer.account;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDateTime;

@Table(name = "accountDetails")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_id;
    private Long accountNumber;
    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private LocalDateTime createdDate;

    public enum AccountStatus{
        ACTIVE,
        FROZEN,
        CLOSED
    }

    @PrePersist
    public void onCreate(){
        this.createdDate=LocalDateTime.now();
    }
}
