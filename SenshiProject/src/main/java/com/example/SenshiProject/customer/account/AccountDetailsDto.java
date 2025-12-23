package com.example.SenshiProject.customer.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailsDto {
    private Long accountNumber;
    private Double balance;

}
