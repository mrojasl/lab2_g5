package com.example.lab2_g5.Repository;

import com.example.lab2_g5.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    List<Currency> findAll();
}
