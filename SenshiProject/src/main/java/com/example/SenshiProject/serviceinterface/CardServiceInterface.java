package com.example.SenshiProject.serviceinterface;


import com.example.SenshiProject.entity.Card;

import java.util.List;

public interface CardServiceInterface {
     Card issueCard(Long accountId);
     List<Card> getCardsByAccount(Long accountId);
     Card activateCard(Long cardId);
     Card blockCard(Long cardId);
     Card unblockCard(Long cardId);
     String closeCard(Long cardId);
}
