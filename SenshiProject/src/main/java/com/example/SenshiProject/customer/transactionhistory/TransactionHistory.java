package com.example.SenshiProject.customer.transactionhistory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;
    private TransactionType type;
    private double amount;
    private TransactionStatus status;
    private String message;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name="account_id")
    private AccountDetails account;


    @PrePersist
    public void setDateTimeNow(){
        this.dateTime=LocalDateTime.now();
    }
}
