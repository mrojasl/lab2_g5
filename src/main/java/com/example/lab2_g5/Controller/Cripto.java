package com.example.lab2_g5.Controller;

import com.example.lab2_g5.Entity.Currency;
import com.example.lab2_g5.Entity.Transaction;
import com.example.lab2_g5.Entity.User;
import com.example.lab2_g5.Entity.Wallet;
import com.example.lab2_g5.Repository.CurrencyRepository;
import com.example.lab2_g5.Repository.TransactionRepository;
import com.example.lab2_g5.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cripto")
public class Cripto {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    WalletRepository walletRepository;

    @GetMapping(value = {"/listtx", ""})
    public String listarTransactions(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("user",user);
        List<Transaction> lista = transactionRepository.findAll();
        model.addAttribute("transactionList", lista);

        return "wallet";
    }

    @PostMapping(value = "/searchtx")
    public String buscarTransactionId(@RequestParam("searchField") String searchField, Model model){
        List<Transaction> lista = transactionRepository.findAll();

        List<Transaction> transactionList = transactionRepository.buscarPorTxId(searchField);
        model.addAttribute("transactionList",transactionList);


        return "wallet";
    }

    @GetMapping("/newtx")
    public String newtx(Model model, HttpSession session){
        User user = null;
        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
        }


        List<Currency> lista1 = currencyRepository.findAll();
        List<Transaction> lista2 = transactionRepository.findAll();
        List<Wallet> lista3 = walletRepository.findAll();

        model.addAttribute("user",user);
        model.addAttribute("currencyList", lista1);
        model.addAttribute("statusList", lista2);
        model.addAttribute("walletList", lista3);

        return "new";
    }

    @PostMapping("/savetx")
    public String savetx(Transaction transaction){
        transactionRepository.save(transaction);
        return "redirect:/cripto/listtx";
    }


}
