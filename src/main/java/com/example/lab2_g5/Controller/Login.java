package com.example.lab2_g5.Controller;

import com.example.lab2_g5.Entity.User;
import com.example.lab2_g5.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class Login {
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    String login(){
        return "inicio2";
    }

    @PostMapping("verificar")
    String verificar(RedirectAttributes attr, Model model, HttpSession session,
                     @RequestParam("correo") String correo, @RequestParam("pswd") String pswd){
        try {
            User user = userRepository.obtenerUserDeEmail(correo);
            if (user.getPassword().equals(pswd)) {
                session.setAttribute("user", user);
                return "redirect:/cripto/listarcurrency";
            }
        }catch (Exception e){
            attr.addFlashAttribute("msg","Error al iniciar sesión");
            return "redirect:/login";
        }
        return "redirect:/login";

    }

}
