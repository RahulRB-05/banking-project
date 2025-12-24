package com.example.SenshiProject.dto;

import com.example.SenshiProject.entity.Account;
import com.example.SenshiProject.enumclasses.CardStatus;
import com.example.SenshiProject.enumclasses.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Random;

@Data
@AllArgsConstructor
public class CardRequestDTO {
    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    private CardType cardType;
    private CardStatus cardStatus;
    private LocalDate issueDate;
    private Account account;

     public CardRequestDTO(){
        this.issueDate= LocalDate.now();

        Random rand=new Random();
        this.cardNumber="7000"+"-"+(1000+rand.nextInt(9000))+"-"+
                (1000+rand.nextInt(9000))+"-"+(1000+rand.nextInt(9000));

        this.cvv=String.valueOf(100+new Random().nextInt(900));
    }
}
