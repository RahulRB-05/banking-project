package com.example.SenshiProject.service;

import com.example.SenshiProject.dto.account.AccountRequestDTO;
import com.example.SenshiProject.dto.account.AccountResponseDTO;
import com.example.SenshiProject.entity.Account;
import com.example.SenshiProject.entity.Customer;
import com.example.SenshiProject.repository.AccountRepository;
import com.example.SenshiProject.repository.CustomerRepository;
import com.example.SenshiProject.serviceinterface.AccountServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService implements AccountServiceInterface {
    private AccountRepository accountRepository;


    private CustomerRepository customerRepository;


    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO) {

        Customer customer = customerRepository.findById(accountRequestDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Account account = new Account();
        account.setAccountNumber(accountRequestDTO.getAccountNumber());
        account.setHolderName(accountRequestDTO.getHolderName());
        account.setBalance(accountRequestDTO.getBalance());
        account.setCustomer(customer);

        Account saved = accountRepository.save(account);
        return mapToResponse(saved);
    }

    @Override
    public AccountResponseDTO getAccountById(int id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Id is not Found"));
        return mapToResponse(account);
    }

    @Override
    public List<AccountResponseDTO> getAllAccount() {
        return accountRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }


    @Override
    public AccountResponseDTO updateAccountById(int id, AccountRequestDTO accountRequestDTO) {
        Account existaccount=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Id is not Found"));
        existaccount.setAccountNumber(accountRequestDTO.getAccountNumber());
        existaccount.setHolderName(accountRequestDTO.getHolderName());
        existaccount.setBalance(accountRequestDTO.getBalance());
        accountRepository.save(existaccount);
        return mapToResponse(existaccount);
    }

    @Override
    public String deleteAccountById(int id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Id is not Found"));
        accountRepository.delete(account);
        return "Successfully Deleted";
    }

    @Override
    public List<AccountResponseDTO> getAccountByStatus(Account.AccountStatus status) {
        return accountRepository.findByStatus(status)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private AccountResponseDTO mapToResponse(Account account) {
        return new AccountResponseDTO(
                account.getAccountId(),
                account.getAccountNumber(),
                account.getHolderName(),
                account.getBalance(),
                account.getStatus(),
                account.getCreatedDate(),
                account.getCustomer().getCustomerId()
        );
    }

}
