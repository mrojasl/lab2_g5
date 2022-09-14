package com.example.lab2_g5.Repository;

import com.example.lab2_g5.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "select idtransaction, neetwork_fee, amount, block, currency, status, wallet_from from transaction",
            nativeQuery = true)
    List<Transaction> listarTransactions();
}
