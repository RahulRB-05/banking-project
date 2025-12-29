package com.example.SenshiProject.service;

import com.example.SenshiProject.dto.account.AccountResponseDTO;
import com.example.SenshiProject.entity.Account;
import com.example.SenshiProject.entity.TransactionHistory;
import com.example.SenshiProject.enumclasses.TransactionType;
import com.example.SenshiProject.repository.AccountRepository;
import com.example.SenshiProject.serviceinterface.TransactionHistoryServiceInterface;
import com.example.SenshiProject.serviceinterface.TransactionServiceInterface;
import jakarta.transaction.Transactional;

public class TransactionService implements TransactionServiceInterface {

    private AccountRepository accountRepository;
    private TransactionHistoryServiceInterface historyServiceInterface;

    @Override
    public AccountResponseDTO depositeAmt(Long accountNumber, Double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Deposit amount must be greater than zero");
        }

        Account account = accountRepository.findById(Math.toIntExact(accountNumber))
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getStatus() != Account.AccountStatus.ACTIVE) {
            throw new RuntimeException("Account is not active");
        }

        account.setBalance(account.getBalance() + amount);
        Account saved = accountRepository.save(account);

        TransactionHistory history = new TransactionHistory();
        history.setAccount(account);
        history.setType(TransactionType.DEPOSIT);
        history.setAmount(amount);

        historyServiceInterface.saveHistory(history);

        return mapToResponse(saved);
    }

    @Override
    public AccountResponseDTO withdrawAmt(Long accountNumber, Double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Withdraw amount must be greater than zero");
        }

        Account account = accountRepository.findById(Math.toIntExact(accountNumber))
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getStatus() != Account.AccountStatus.ACTIVE) {
            throw new RuntimeException("Account is not active");
        }

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        Account saved = accountRepository.save(account);

        TransactionHistory history = new TransactionHistory();
        history.setAccount(account);
        history.setType(TransactionType.WITHDRAW);
        history.setAmount(amount);

        historyServiceInterface.saveHistory(history);

        return mapToResponse(saved);
    }

    @Override
    @Transactional
    public String transferAmt(Long fromAccountNumber, Long toAccountNumber, Double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Transfer amount must be greater than zero");
        }

        Account fromAccount = accountRepository.findById(Math.toIntExact(fromAccountNumber))
                .orElseThrow(() -> new RuntimeException("From account not found"));

        Account toAccount = accountRepository.findById(Math.toIntExact(toAccountNumber))
                .orElseThrow(() -> new RuntimeException("To account not found"));

        if (fromAccount.getStatus() != Account.AccountStatus.ACTIVE ||
                toAccount.getStatus() != Account.AccountStatus.ACTIVE) {
            throw new RuntimeException("Both accounts must be active");
        }

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);

        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        TransactionHistory fromHistory = new TransactionHistory();
        fromHistory.setAccount(fromAccount);
        fromHistory.setType(TransactionType.TRANSFER_DEBIT);
        fromHistory.setAmount(amount);


        TransactionHistory toHistory = new TransactionHistory();
        toHistory.setAccount(toAccount);
        toHistory.setType(TransactionType.TRANSFER_CREDIT);
        toHistory.setAmount(amount);


        historyServiceInterface.saveHistory(fromHistory);
        historyServiceInterface.saveHistory(toHistory);

        return "Transfer successful";
    }

    private AccountResponseDTO mapToResponse(Account account) {
        return new AccountResponseDTO(
                account.getAccount_id(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getStatus(),
                account.getCreatedDate(),
                account.getCustomer().getCustomerId()
        );
    }
}