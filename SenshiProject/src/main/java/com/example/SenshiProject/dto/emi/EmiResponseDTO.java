package com.example.SenshiProject.dto.emi;

import com.example.SenshiProject.entity.Emi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmiResponseDTO {
    private Integer emiId;
    private Integer emiNumber;
    private Double emiAmount;
    private LocalDateTime dueDate;
    private Emi.EmiStatus status;
}
