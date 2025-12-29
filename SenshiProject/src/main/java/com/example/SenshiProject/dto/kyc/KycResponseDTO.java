package com.example.SenshiProject.dto.kyc;

import com.example.SenshiProject.entity.Kyc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @AllArgsConstructor
    @Data
    @NoArgsConstructor

    public class KycResponseDTO {


        private Integer kycId;
        private String kycStatus;
        private String message;


}
