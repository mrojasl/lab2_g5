package com.example.lab2_g5.Repository;

import com.example.lab2_g5.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByTxId(String id);

    @Query(nativeQuery = true,
    value = "SELECT * FROM transaction where tx_id like %?1%")
    List<Transaction> buscarPorTxId(String text);
    List<Transaction> findAll();
}
