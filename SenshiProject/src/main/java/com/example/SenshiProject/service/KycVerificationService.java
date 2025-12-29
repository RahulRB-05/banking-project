package com.example.SenshiProject.service;

import com.example.SenshiProject.dto.kyc.KycRequestDTO;
import com.example.SenshiProject.dto.kyc.KycResponseDTO;
import com.example.SenshiProject.entity.Customer;
import com.example.SenshiProject.entity.Kyc;
import com.example.SenshiProject.repository.CustomerRepository;
import com.example.SenshiProject.repository.KycRepository;
import com.example.SenshiProject.serviceinterface.KycServiceInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class KycVerificationService implements KycServiceInterface {
    @Autowired
    private KycRepository kycRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public KycResponseDTO submitKyc(int customerId, KycRequestDTO request) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()->new RuntimeException("ID NOT FOUND"));

        if(customer.getKycVerificationForm()!=null){
            throw  new IllegalStateException("KYC ALREADY SUBMITTED KINDLY CHECK THE STATUS");

        }

        Kyc kyc =  new Kyc();
        kyc.setAadhaarNo(request.getAadhaarNo());
        kyc.setPanNo(request.getPanNo());
        kyc.setKycStatus(Kyc.KycStatus.PENDING);

        kyc.setCustomerDetails(customer);
        customer.setKycVerificationForm(kyc);

         customerRepository.save(customer);

        return new KycResponseDTO(customer.getKycVerificationForm().getKycId(),
                Kyc.KycStatus.PENDING.name(),"KYC SUBMITTED SUCCESSFULLY" );
    }

    @Override
    public void updateKycStatus(int id, Kyc.KycStatus status) {

       Kyc kyc = kycRepository.findById(id)
                .orElseThrow(()->new RuntimeException("ID NOT FOUND"));

       if(kyc.getKycStatus()== Kyc.KycStatus.APPROVED){
           throw new IllegalStateException("KYC IS ALREADY APPROVED");
       }


       kyc.setKycStatus(status);

       kycRepository.save(kyc);

    }

//    @Override
//    public List<Kyc> getAllStatus(Kyc.KycStatus status) {
//
//      List<Kyc> kyc = kycRepository.findByKycStatus(status);
//
//       return  kyc.stream().map(this::mapToKyc).toList();
//
//    }

    @Override
    public KycResponseDTO getKycStatus(int kycId) {

        Customer customer= customerRepository.findById(kycId)
                .orElseThrow(()-> new RuntimeException("ID NOT FOUND"));

        if(customer.getKycVerificationForm()==null){
            return new KycResponseDTO(kycId,
                    "PENDING","KINDLY SUBMIT KYC DETAILS");
        }


         return new KycResponseDTO(kycId,
                 customer.getKycVerificationForm()
                         .getKycStatus().name(),"CURRENT KYC STATUS" );

    }

}

