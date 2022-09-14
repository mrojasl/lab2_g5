package com.example.lab2_g5.Repository;

import com.example.lab2_g5.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
