package com.example.SenshiProject.repository;

import com.example.SenshiProject.entity.Kyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface KycRepository extends JpaRepository<Kyc,Integer> {

}
