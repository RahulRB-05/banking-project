package com.example.SenshiProject.exception.customexception;

import com.example.SenshiProject.repository.AccountRepository;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message){
        super(message);
    }
}
