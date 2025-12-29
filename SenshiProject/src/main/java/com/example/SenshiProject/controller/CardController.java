package com.example.SenshiProject.controller;

import com.example.SenshiProject.entity.Card;
import com.example.SenshiProject.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/issueCard/{accountId}")
    public Card issueCard(@PathVariable int accountId){
        return cardService.issueCard(accountId);
    }

    @GetMapping("/{accountId/getCards}")
    public List<Card> getCards(@PathVariable int accountId){
        return cardService.getCardsByAccount(accountId);
    }

    @PutMapping("/{cardId}/activateCard")
    public Card activateCard(@PathVariable int  cardId){
        return cardService.activateCard(cardId);
    }

    @PutMapping("/{cardId}/blockCard")
    public Card blockCard(@PathVariable int cardId){
        return cardService.blockCard(cardId);
    }

    @PutMapping("/{cardId}/unblockCard")
    public Card unblockCard(@PathVariable int  cardId){
        return cardService.unblockCard(cardId);
    }

    @PutMapping("/{cardId}/closeCard")
    public String closeCard(int  cardId){
        return cardService.closeCard(cardId);
    }
}
