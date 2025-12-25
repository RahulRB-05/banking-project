package com.example.SenshiProject.controller;

import com.example.SenshiProject.dto.customer.CustomerRequestDTO;
import com.example.SenshiProject.dto.customer.CustomerResponseDTO;
import com.example.SenshiProject.dto.customer.UpdateCustomerDetailsDTO;
import com.example.SenshiProject.entity.Customer;
import com.example.SenshiProject.serviceinterface.CustomerServiceInterface;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor

public class CustomerController {

    @Autowired
    private CustomerServiceInterface service ;

    @PostMapping("/createcustomer")
    public CustomerResponseDTO createNewCustomerDetails(@Valid @RequestBody CustomerRequestDTO customerRequestDTO){

        return service.createCustomerDetails(customerRequestDTO);
    }


    @GetMapping("/all-customerDetails")
    public List<Customer> getAllCustomerDetails(){
        return service.getAllCustomer();
    }

    @GetMapping("/customerDetails/{id}")
    public CustomerResponseDTO getCustomerDetailById(@PathVariable int id){
        return service.getCustomerById(id);
    }


    @PutMapping("/updatedetails-byid/{id}")
    public CustomerResponseDTO updateCustomerDetails(@PathVariable int id, @RequestBody UpdateCustomerDetailsDTO update){
        return service.updateCustomerDetails(id,update);
    }

}
