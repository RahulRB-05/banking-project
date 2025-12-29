package com.example.SenshiProject.dto.account;

import com.example.SenshiProject.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import com.example.SenshiProject.entity.Account.AccountStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDTO {

    private Integer accountId;
    private Long accountNumber;
    private String holderName;
    private Double balance;
    private AccountStatus status;
    private LocalDateTime createdDate;
    private Integer customerId;
}

