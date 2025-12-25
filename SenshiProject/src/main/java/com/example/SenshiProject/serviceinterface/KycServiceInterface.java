package com.example.SenshiProject.serviceinterface;

import com.example.SenshiProject.dto.kyc.KycRequestDTO;
import com.example.SenshiProject.dto.kyc.KycResponseDTO;

public interface KycServiceInterface{

    // posting the customer details for kyc creation -- customer as well as admin
    // kyc creating
  KycResponseDTO submitKyc (int id, KycRequestDTO request);

//  KycResponseDTO vertifyKyc(int id,)









}


