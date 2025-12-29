package com.example.SenshiProject.service;

import com.example.SenshiProject.entity.TransactionHistory;
import com.example.SenshiProject.enumclasses.TransactionType;
import com.example.SenshiProject.exception.customexception.AccountNotFoundException;
import com.example.SenshiProject.repository.AccountRepository;
import com.example.SenshiProject.repository.TransactionHistoryRepository;
import com.example.SenshiProject.serviceinterface.TransactionHistoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionHistoryServiceClass implements TransactionHistoryServiceInterface {

    @Autowired
    TransactionHistoryRepository transactionRepo;
    @Autowired
    AccountRepository accountRepo;

    @Override
    public void saveHistory(TransactionHistory transactionHistory) {
        transactionRepo.save(transactionHistory);
    }

    @Override
    public List<TransactionHistory> getAllTransactions(Long accountId) {
        accountRepo.findById(accountId).orElseThrow(()->new AccountNotFoundException("User Account Not Found !!!"));
        return transactionRepo.findByAccountId(accountId);
    }

    @Override
    public List<TransactionHistory> getTransactionsByDate(Long accountId, LocalDateTime from, LocalDateTime to) {
        accountRepo.findById(accountId).orElseThrow(()->new AccountNotFoundException("User Account Not Found !!!"));
        return transactionRepo.findByAccountIdAndTransactionDateBetween(accountId,from,to);
    }

    @Override
    public List<TransactionHistory> getTransactionByType(Long accountId, TransactionType type) {
        accountRepo.findById(accountId).orElseThrow(()->new AccountNotFoundException("User Account Not Found !!!"));
        return transactionRepo.findByAccountIdAndType(accountId,type);
    }
}
