package com.example.SenshiProject.controller;

import com.example.SenshiProject.serviceinterface.EmiServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmiController {
    private EmiServiceInterface emiServiceInterface;


}
