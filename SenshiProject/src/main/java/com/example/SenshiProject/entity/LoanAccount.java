package com.example.SenshiProject.entity;

import com.example.SenshiProject.enumclasses.LoanAccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private double loanAmount;
    private double interestRate;
    private int tenureMonth;
    private double emiAmount;
    private double outstandingAmount;

    @Enumerated(EnumType.STRING)
    private LoanAccountStatus loanStatus;

    private LocalDate loanStartDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
