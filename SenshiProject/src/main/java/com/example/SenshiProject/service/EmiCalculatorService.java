package com.example.SenshiProject.service;

import org.springframework.stereotype.Service;

@Service
public class EmiCalculatorService {
    public double calculateEmi(double principal,double annualRate,int tenureMonths){
        double monthlyRate=annualRate/12/100;
        double calculatedEmi=principal*monthlyRate* Math.pow(1+monthlyRate,tenureMonths)/
                (Math.pow(1+monthlyRate,tenureMonths)-1);
        return calculatedEmi;
    }
}
