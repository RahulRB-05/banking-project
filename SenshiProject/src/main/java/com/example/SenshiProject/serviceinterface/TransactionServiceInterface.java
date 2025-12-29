package com.example.SenshiProject.serviceinterface;

import com.example.SenshiProject.dto.account.AccountResponseDTO;

public interface TransactionServiceInterface {
    AccountResponseDTO depositeAmt(Long accountNumber,Double amount);
    AccountResponseDTO withdrawAmt(Long accountNumber,Double amount);
    String transferAmt(Long fromAccountNumber,Long toAccountNumber,Double amount);
}
