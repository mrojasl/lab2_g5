package com.example.lab2_g5.Repository;

import com.example.lab2_g5.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
}
