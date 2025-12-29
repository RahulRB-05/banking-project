package com.example.SenshiProject.dto.account;

import com.example.SenshiProject.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDTO {

    private Integer account_id;
    private Long accountNumber;
    private String holderName;
    private Double balance;
    private Account.AccountStatus status;
    private LocalDateTime createdDate;
    private Integer customerId;
}

