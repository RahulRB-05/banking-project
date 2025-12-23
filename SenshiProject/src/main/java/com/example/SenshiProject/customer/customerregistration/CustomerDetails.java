package com.example.SenshiProject.customer.customerregistration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="customerDetails")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDetails
{

    private Integer customerId;
    private String customerName;
    private String email;
    private long mobileNumber;
    private LocalDate dob;
    private String address;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    private LocalDateTime createdAt;


//@OneToMany(mappedBy ="customerDetails")
//    private AccountDetails account






   public enum CustomerStatus{
       ACTIVE,
       BLOCKED

   }
@PrePersist
 public void createdDate(){
       this.createdAt =LocalDateTime.now();
 }









}
