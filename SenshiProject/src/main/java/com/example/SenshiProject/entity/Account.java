package com.example.SenshiProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<TransactionHistory> transactionHistory;

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
