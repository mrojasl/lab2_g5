package com.example.lab2_g5.Controller;

import com.example.lab2_g5.Entity.Transaction;
import com.example.lab2_g5.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cripto")
public class Cripto {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping(value = {"/listtx", ""})
    public String listarTransactions(Model model) {

        List<Transaction> lista = transactionRepository.findAll();
        model.addAttribute("transactionList", lista);

        return "wallet";
    }

    @PostMapping(value = "/searchtx")
    public String buscarTransactionId(@RequestParam("searchField") String searchField, Model model){

        try {
            List<Transaction> transactionList = transactionRepository.findByTxId(searchField);
            model.addAttribute("transactionList",transactionList);
        }catch (NumberFormatException e){
            System.out.println("Error de parseo");
        }
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
