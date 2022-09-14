package com.example.lab2_g5.Controller;

import com.example.lab2_g5.Entity.Transaction;
import com.example.lab2_g5.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Cripto {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping(value = {"/list", ""})
    public String listarTransactions(Model model) {

        List<Transaction> lista = transactionRepository.listarTransactions();
        model.addAttribute("transactionList", lista);

        return "wallet";
    }

    @GetMapping("newtx")
    String newtx(){

        return "new";
    }

    @GetMapping("savetx")
    String savetx(Transaction transaction){
        transactionRepository.save(transaction);


        return "redirect:/newtx";
    }


}
