package com.example.lab2_g5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
}
