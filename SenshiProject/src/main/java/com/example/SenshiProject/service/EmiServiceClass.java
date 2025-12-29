package com.example.SenshiProject.service;

import com.example.SenshiProject.repository.EmiRepository;
import com.example.SenshiProject.serviceinterface.EmiServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmiServiceClass implements EmiServiceInterface {
    private EmiRepository emiRepository;
}
