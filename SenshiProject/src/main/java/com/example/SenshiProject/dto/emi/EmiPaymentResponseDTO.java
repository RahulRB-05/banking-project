package com.example.SenshiProject.dto.emi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmiPaymentResponseDTO {

    private String message;
    private Double remainingBalance;
    private EmiResponseDTO emi;
}
