package com.example.lab2_g5.Repository;

import com.example.lab2_g5.Entity.Transaction;
import com.example.lab2_g5.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user where email = ?1",
            nativeQuery = true)
    User obtenerUsuarioDeEmail(String email);
}
