package com.example.SenshiProject.serviceinterface;

import com.example.SenshiProject.entity.TransactionHistory;
import com.example.SenshiProject.enumclasses.TransactionType;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionHistoryServiceInterface {

    void saveHistory(TransactionHistory transactionHistory);

    List<TransactionHistory> getAllTransactions(int  accountId);

    List<TransactionHistory> getTransactionByType(int accountId, TransactionType type);

    List<TransactionHistory> getTransactionsByDate(int accountId, LocalDateTime from ,LocalDateTime to);
}
