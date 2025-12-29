package com.example.SenshiProject.repository;

import com.example.SenshiProject.entity.TransactionHistory;
import com.example.SenshiProject.enumclasses.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Long> {

    List<TransactionHistory> findByAccountId(int accountId);

    List<TransactionHistory> findByAccountIdAndType(int accountId, TransactionType type);

    List<TransactionHistory> findByAccountIdAndTransactionDateBetween(int accountId, LocalDateTime from,LocalDateTime to);
}
