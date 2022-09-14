package com.example.lab2_g5.Controller;

import com.example.lab2_g5.Entity.User;
import com.example.lab2_g5.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class Login {
    @Autowired
    UserRepository userRepository;

    @PostMapping("verificar")
    String verificar(@RequestParam("correo") String correo, @RequestParam("pswd") String pswd){
        Optional<User> optionalUser = userRepository.encontrarUsuario(correo);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
        }
        return "";
    }

}
