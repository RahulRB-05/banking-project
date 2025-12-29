package com.example.SenshiProject.service;

import com.example.SenshiProject.dto.customer.CustomerRequestDTO;
import com.example.SenshiProject.dto.customer.CustomerResponseDTO;
import com.example.SenshiProject.dto.customer.UpdateCustomerDetailsDTO;
import com.example.SenshiProject.entity.Customer;
import com.example.SenshiProject.repository.CustomerRepository;
import com.example.SenshiProject.serviceinterface.CustomerServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @AllArgsConstructor
    @Service

    public class CustomerService  implements CustomerServiceInterface {

        @Autowired
        private CustomerRepository customerRepo;


        @Override
        public CustomerResponseDTO createCustomerDetails(CustomerRequestDTO customerRequest) {

            // ---  customer details are collect

            Customer customerDetails = getCustomer(customerRequest);

            // customer details save in the database to get the customer id because customer id is auto generate

            Customer customerAllDetails = customerRepo.save(customerDetails);

            // above customeralldetails has the id of the customer now we can send the reponse to the customer using the a
//        using the auto id


            return mapToCustomerResponse(customerAllDetails);// this is used to convert the entity to dto
        }

        private static Customer getCustomer(CustomerRequestDTO customerRequest) {
            Customer customerDetails = new Customer();

            customerDetails.setCustomerName(customerRequest.getCustomerName());
            customerDetails.setCustomerAge(customerRequest.getCustomerAge());
            customerDetails.setCustomerEmail(customerRequest.getCustomerEmail());
            customerDetails.setCustomerAddress(customerRequest.getCustomerAddress());
            customerDetails.setMobileNo(customerRequest.getMobileNo());
            customerDetails.setDob(customerRequest.getDob());
            customerDetails.setCreatedAt(customerRequest.getCreatedAt());
            return customerDetails;
        }

        @Override
        public List<Customer> getAllCustomer() {

            List<Customer> customers = customerRepo.findAll();

            return customers;
        }

        @Override
        public CustomerResponseDTO getCustomerById(int id) {

            Customer customer =customerRepo.findById(id).orElseThrow(()->new RuntimeException("ID NOT FOUND"+id));

            return mapToCustomerResponse(customer);
        }

        @Override
        public CustomerResponseDTO updateCustomerDetails(int id, UpdateCustomerDetailsDTO updateCustomer) {
            Customer customer=customerRepo.findById(id).orElseThrow(()->new RuntimeException("ID NOT FOUND"));

            if(updateCustomer!=null){

                if(updateCustomer.getCustomerName()!=null){
                    customer.setCustomerName(updateCustomer.getCustomerName());
                }

                if(updateCustomer.getCustomerEmail()!=null){
                    customer.setCustomerEmail(updateCustomer.getCustomerEmail());
                }

                if(updateCustomer.getCustomerAddress()!=null){
                    customer.setCustomerAddress(updateCustomer.getCustomerAddress());
                }

                if(updateCustomer.getMobileNo()!=null){
                    customer.setMobileNo(updateCustomer.getMobileNo());
                }

            }

            Customer updatedCustomer = customerRepo.save(customer);

            return mapToCustomerResponse(updatedCustomer);
        }






        // service class method
        private CustomerResponseDTO mapToCustomerResponse(Customer customer){

            CustomerResponseDTO response  = new CustomerResponseDTO();

            response.setCustomerID(customer.getCustomerId());
            response.setCustomerName(customer.getCustomerName());
            response.setCustomerAge(customer.getCustomerAge());
            response.setCustomerEmail(customer.getCustomerEmail());
            response.setCustomerAddress(customer.getCustomerAddress());
            response.setMobileNo(customer.getMobileNo());
            response.setDob(customer.getDob());

            if (customer.getKycVerificationForm()!= null){

                response.setKycStatus(customer.getKycVerificationForm().getKycStatus().name());
            }

            else{

                response.setKycStatus("KYC NOT_SUBMITTED");
            }

            return response;
        }






    }
