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
    public Card issueCard(@PathVariable Long accountId){
        return cardService.issueCard(accountId);
    }

    @GetMapping("/{accountId/getCards}")
    public List<Card> getCards(@PathVariable Long accountId){
        return cardService.getCardsByAccount(accountId);
    }

    @PutMapping("/{cardId}/activateCard")
    public Card activateCard(@PathVariable Long cardId){
        return cardService.activateCard(cardId);
    }

    @PutMapping("/{cardId}/blockCard")
    public Card blockCard(@PathVariable Long cardId){
        return cardService.blockCard(cardId);
    }

    @PutMapping("/{cardId}/unblockCard")
    public Card unblockCard(@PathVariable Long cardId){
        return cardService.unblockCard(cardId);
    }

    @PutMapping("/{cardId}/closeCard")
    public String closeCard(Long cardId){
        return cardService.closeCard(cardId);
    }
}
