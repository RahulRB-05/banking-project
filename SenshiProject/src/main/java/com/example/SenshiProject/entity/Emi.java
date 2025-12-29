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
public class Emi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emiId;
    private Integer emiNumber;
    private Double emiAmount;
    private LocalDateTime dueDate;
    @Enumerated(EnumType.STRING)
    private EmiStatus status;
    @ManyToOne
    @JoinColumn(name = "loanId")
    private Loan loan;

    public enum EmiStatus{
        PENDING,
        PAID,
        OVERDUE
    }
    @PrePersist
    public void onCreate(){

        this.dueDate=LocalDateTime.now();
    }
}