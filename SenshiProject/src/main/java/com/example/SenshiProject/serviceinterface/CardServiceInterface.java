package com.example.SenshiProject.serviceinterface;


import com.example.SenshiProject.entity.Card;

import java.util.List;

public interface CardServiceInterface {
     Card issueCard(int  accountId);
     List<Card> getCardsByAccount(int  accountId);
     Card activateCard(int  cardId);
     Card blockCard(int cardId);
     Card unblockCard(int  cardId);
     String closeCard(int  cardId);
}
