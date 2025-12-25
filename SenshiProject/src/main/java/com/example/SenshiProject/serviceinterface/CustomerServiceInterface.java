package com.example.SenshiProject.serviceinterface;

import com.example.SenshiProject.dto.customer.CustomerRequestDTO;
import com.example.SenshiProject.dto.customer.CustomerResponseDTO;
import com.example.SenshiProject.dto.customer.UpdateCustomerDetailsDTO;
import com.example.SenshiProject.entity.Customer;

import java.util.List;


    public interface CustomerServiceInterface {

        // adding  a new customer -- customer usage
        CustomerResponseDTO createCustomerDetails(CustomerRequestDTO customerRequest );
        //viewing the all customer in the bank -- admin usage
        List<Customer> getAllCustomer();
        // viewing the customer details by the id -- both admin and customer
        CustomerResponseDTO getCustomerById(int id );
        //update customer by customer id -- Both customer and admin
        CustomerResponseDTO updateCustomerDetails(int id, UpdateCustomerDetailsDTO updateCustomer);
        // list of customer updating  -- only admin
//    List<Customer> updateAllCustomersStatus(Customer.CustomerStatus status);


    }
