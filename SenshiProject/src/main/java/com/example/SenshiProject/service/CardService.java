package com.example.SenshiProject.service;

import com.example.SenshiProject.dto.CardRequestDTO;
import com.example.SenshiProject.entity.Account;
import com.example.SenshiProject.entity.Card;
import com.example.SenshiProject.enumclasses.CardStatus;
import com.example.SenshiProject.enumclasses.CardType;
import com.example.SenshiProject.exception.customexception.AccountNotFoundException;
import com.example.SenshiProject.exception.customexception.CardNotFoundException;
import com.example.SenshiProject.repository.AccountRepository;
import com.example.SenshiProject.repository.CardRepository;
import com.example.SenshiProject.serviceinterface.CardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements CardServiceInterface {
    @Autowired
    private CardRepository cardRepo;
    @Autowired
    private AccountRepository accountRepo;

    @Override
    public Card issueCard(Long accountId) {
       Account account= accountRepo.findById(accountId).orElseThrow(()->new AccountNotFoundException("No Account Found"));

        CardRequestDTO newCard=new CardRequestDTO();
//        newCard.setCardHolderName(account.getAccountHolderrName());
        newCard.setCardType(CardType.DEBIT);
        newCard.setCardStatus(CardStatus.INACTIVE);
        newCard.setAccount(account);

        Card newCardIssued=mapTo(newCard);
        return cardRepo.save(newCardIssued);
    }

    @Override
    public List<Card> getCardsByAccount(Long accountId) {
        return cardRepo.findByAccountId(accountId);
    }

    @Override
    public Card activateCard(Long cardId) {
        Card activateCard=cardRepo.findById(cardId).orElseThrow(()-> new CardNotFoundException("No Card Found"));
        activateCard.setCardStatus(CardStatus.ACTIVE);

        return cardRepo.save(activateCard);
    }

    @Override
    public Card blockCard(Long cardId) {
        Card blockCard=cardRepo.findById(cardId).orElseThrow(()->new CardNotFoundException("No Card Found"));
        blockCard.setCardStatus(CardStatus.BLOCKED);

        return cardRepo.save(blockCard);
    }

    @Override
    public Card unblockCard(Long cardId) {
        Card unblockCard=cardRepo.findById(cardId).orElseThrow(()->new CardNotFoundException("No Card Found"));
        unblockCard.setCardStatus(CardStatus.ACTIVE);

        return cardRepo.save(unblockCard);
    }

    @Override
    public String closeCard(Long cardId) {
        Card closeCard=cardRepo.findById(cardId).orElseThrow(()->new CardNotFoundException("No Card Found"));
        closeCard.setCardStatus(CardStatus.CLOSED);

        return "Card Closed Successfully !!!";
    }

    public Card mapTo(CardRequestDTO cardDTO){
        Card newCardMap=new Card();
        newCardMap.setCardHolderName(cardDTO.getCardHolderName());
        newCardMap.setCardNumber(cardDTO.getCardNumber());
        newCardMap.setCvv(cardDTO.getCvv());
        newCardMap.setCardType(cardDTO.getCardType());
        newCardMap.setCardStatus(cardDTO.getCardStatus());
        newCardMap.setIssueDate(cardDTO.getIssueDate());
        newCardMap.setAccount(cardDTO.getAccount());

        return newCardMap;
    }
}
