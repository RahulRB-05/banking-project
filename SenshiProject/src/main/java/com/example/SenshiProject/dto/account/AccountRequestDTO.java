package com.example.SenshiProject.dto.account;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDTO {

    @NotNull(message = "Account Number is required")
    private Long accountNumber;

    @NotBlank(message = "HolderName must not be blank")
    private String holderName;

    @Min(value = 100, message = "Balance must be at least 100")
    @Max(value = 100000, message = "Balance must be at most 100000")
    private Double balance;

    @NotNull(message = "customerId is required")
    private Integer customerId;
}
