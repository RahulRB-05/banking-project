package com.example.SenshiProject.controller;

import com.example.SenshiProject.dto.kyc.KycRequestDTO;
import com.example.SenshiProject.dto.kyc.KycResponseDTO;
import com.example.SenshiProject.entity.Kyc;
import com.example.SenshiProject.serviceinterface.KycServiceInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@AllArgsConstructor
public class KycController
{
    @Autowired
    private KycServiceInterface service;


    @PostMapping("/kyc/{id}")
    public KycResponseDTO createKyc(@PathVariable int customerId, @RequestBody KycRequestDTO request){

       return service.submitKyc(customerId, request);

    }

    @PutMapping("/status/{id}/status")
    public void updateKycStatusById(@PathVariable int KycId,@RequestParam Kyc.KycStatus status){
       service.updateKycStatus(KycId,status);

    }

    @GetMapping("/Kyc-currentstatus/{id}")
    public KycResponseDTO getKycDetails(@PathVariable int id){
        return service.getKycStatus(id);
    }



}
