package com.example.SenshiProject.serviceinterface;

import com.example.SenshiProject.dto.account.AccountRequestDTO;
import com.example.SenshiProject.dto.account.AccountResponseDTO;
import com.example.SenshiProject.entity.Account;

import java.util.List;

public interface AccountServiceInterface{
    AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO);
    AccountResponseDTO getAccountById(int id);
    List<AccountResponseDTO> getAllAccount();
    AccountResponseDTO updateAccountById(int id, AccountRequestDTO accountRequestDTO);
    String deleteAccountById(int id);
    List<AccountResponseDTO> getAccountByStatus(Account.AccountStatus status);
}
