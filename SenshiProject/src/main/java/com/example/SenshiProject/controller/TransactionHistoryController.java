package com.example.SenshiProject.controller;

import com.example.SenshiProject.entity.TransactionHistory;
import com.example.SenshiProject.enumclasses.TransactionType;
import com.example.SenshiProject.serviceinterface.TransactionHistoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TransactionHistoryController {

    @Autowired
    private TransactionHistoryServiceInterface transactionService;

    @GetMapping("/getAllTransactions")
    public List<TransactionHistory> allTransactions(@RequestParam Long accountId){
        return transactionService.getAllTransactions(accountId);
    }

    @GetMapping("/getTransactionByType")
    public List<TransactionHistory> getTransactionsByType(@RequestParam Long accountId,@RequestParam TransactionType type){
        return transactionService.getTransactionByType(accountId,type);
    }

    @GetMapping("/getTransactionsByDate")
    public List<TransactionHistory> getTransactionsByDate(@RequestParam Long accountId,String from,String to){
        LocalDateTime fromDate=LocalDateTime.parse(from);
        LocalDateTime toDate=LocalDateTime.parse(to);
        return transactionService.getTransactionsByDate(accountId,fromDate,toDate);
    }
 }
