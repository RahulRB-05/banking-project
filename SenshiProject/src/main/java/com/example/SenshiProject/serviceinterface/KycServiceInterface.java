package com.example.SenshiProject.serviceinterface;

import com.example.SenshiProject.dto.kyc.KycRequestDTO;
import com.example.SenshiProject.dto.kyc.KycResponseDTO;
import com.example.SenshiProject.entity.Kyc;

import java.util.List;

public interface KycServiceInterface{

    // posting the customer details for kyc creation -- customer as well as admin
    // kyc creating
  KycResponseDTO submitKyc (int id, KycRequestDTO request);
  // used to update the status of the customer
//    -- only for the admin
  void updateKycStatus (int id, Kyc.KycStatus status);
// it is used to get all the pending status
//    --- only for the admin
//  List<Kyc> getAllStatus(Kyc.KycStatus status);
// it is used to get the kyc status for the customer
//    -- both admin and customer
  KycResponseDTO getKycStatus(int customerId);








}


