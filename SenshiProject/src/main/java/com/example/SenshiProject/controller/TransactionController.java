package com.example.SenshiProject.controller;

import com.example.SenshiProject.dto.account.AccountResponseDTO;
import com.example.SenshiProject.serviceinterface.TransactionServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class TransactionController {
    private TransactionServiceInterface transactionServiceInterface;

    @GetMapping("/deposite/{accountNumber}/{amount}")
    public AccountResponseDTO deposite(@PathVariable Long accountNumber,@PathVariable Double amount){
        return transactionServiceInterface.depositeAmt(accountNumber,amount);
    }

    @GetMapping("/withdraw/{accountNumber}/{amount}")
    public AccountResponseDTO withdraw(@PathVariable Long accountNumber,@PathVariable Double amount){
        return transactionServiceInterface.withdrawAmt(accountNumber,amount);
    }

    @GetMapping("/transfer/{fromAccountNumber}/{toAccountNumber}/{amount}")
    public String transfer(@PathVariable Long fromAccountNumber,@PathVariable Long toAccountNumber,@PathVariable Double amount){
        return transactionServiceInterface.transferAmt(fromAccountNumber,toAccountNumber,amount);
    }
}
