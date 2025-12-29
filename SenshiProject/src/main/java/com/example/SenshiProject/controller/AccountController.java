package com.example.SenshiProject.controller;

import com.example.SenshiProject.dto.account.AccountRequestDTO;
import com.example.SenshiProject.dto.account.AccountResponseDTO;
import com.example.SenshiProject.entity.Account;
import com.example.SenshiProject.serviceinterface.AccountServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceInterface accountServiceInterface;

    @PostMapping("/createAccount")
    public AccountResponseDTO create(@RequestBody @Valid AccountRequestDTO accountRequestDTO){
        return accountServiceInterface.createAccount(accountRequestDTO);
    }

    @GetMapping("/getAccountId/{id}")
    public AccountResponseDTO getById(@PathVariable int id){
        return accountServiceInterface.getAccountById(id);
    }

    @GetMapping("/getAllAccount")
    public List<AccountResponseDTO> getAll(){
        return accountServiceInterface.getAllAccount();
    }

    @PutMapping("/updateAccount/{id}")
    public AccountResponseDTO updateId(@PathVariable int id,@RequestBody @Valid AccountRequestDTO accountRequestDTO){
        return accountServiceInterface.updateAccountById(id, accountRequestDTO);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public String deleteId(@PathVariable int id){
        return accountServiceInterface.deleteAccountById(id);
    }

    @GetMapping("/getBystatus/{status}")
    public List<AccountResponseDTO> getByStatus(
            @PathVariable Account.AccountStatus status) {
        return accountServiceInterface.getAccountByStatus(status);
    }
}
