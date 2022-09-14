package com.example.lab2_g5.Controller;

import com.example.lab2_g5.Entity.User;
import com.example.lab2_g5.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class Login {
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    String login(){
        return "inicio2";
    }

    @PostMapping("verificar")
    String verificar(@RequestParam("correo") String correo, @RequestParam("pswd") String pswd){
        User user = userRepository.obtenerUsuarioDeEmail(correo);
        if (user.getEmail()!= null && !user.getEmail().isEmpty()){

        }
        return "";
    }

}
