package com.example.SenshiProject.repository;

import com.example.SenshiProject.entity.LoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccount,Long> {
}
