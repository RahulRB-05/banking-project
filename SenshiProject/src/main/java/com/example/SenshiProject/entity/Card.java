package com.example.SenshiProject.entity;

import com.example.SenshiProject.enumclasses.CardStatus;
import com.example.SenshiProject.enumclasses.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    private String cardNumber;
    private String cardHolderName;
    private int expiryMonth;
    private int expiryYear;
    private String cvv;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    private boolean internationalEnable;
    private boolean onlineEnable;
    private boolean contactlessEnable;

    private LocalDate issueDate;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

}
