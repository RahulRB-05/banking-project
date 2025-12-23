package com.example.SenshiProject.customer.transactionhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryService {
 @Autowired
    private TransactionHistoryRepository transactionRepo;


    public void saveTransactions(AccountDetails accountDetails,double amount,
                                 TransactionType type,TransactionStatus status,String message){
        TransactionHistory th=new TransactionHistory();

    }
}
