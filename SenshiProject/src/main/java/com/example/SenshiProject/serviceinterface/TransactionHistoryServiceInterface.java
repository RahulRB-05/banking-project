package com.example.SenshiProject.serviceinterface;

import com.example.SenshiProject.entity.TransactionHistory;
import com.example.SenshiProject.enumclasses.TransactionType;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionHistoryServiceInterface {

    List<TransactionHistory> getAllTransactions(Long accountId);

    List<TransactionHistory> getTransactionByType(Long accountId, TransactionType type);

    List<TransactionHistory> getTransactionsByDate(Long accountId, LocalDateTime from ,LocalDateTime to);
}
