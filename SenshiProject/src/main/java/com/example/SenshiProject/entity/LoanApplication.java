package com.example.SenshiProject.entity;

import com.example.SenshiProject.enumclasses.LoanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanAppId;

    private double requestAmount;
    private int tenureMonths;

    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    private LocalDate appliedDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "loan_type_id")
    private LoanType loanType;
}
