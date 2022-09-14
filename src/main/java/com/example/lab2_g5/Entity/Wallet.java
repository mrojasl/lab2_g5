package com.example.lab2_g5.Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @Column(name = "idwallet", nullable = false)
    private Integer id;

    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_iduser", nullable = false)
    private User userIduser;

    @Column(name = "total_usd", nullable = false, length = 45)
    private String totalUsd;

    @OneToMany(mappedBy = "wallet")
    private Set<com.example.lab2_g5.WalletHasCurrencyWallet> walletHasCurrencyWallets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "walletFrom")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(User userIduser) {
        this.userIduser = userIduser;
    }

    public String getTotalUsd() {
        return totalUsd;
    }

    public void setTotalUsd(String totalUsd) {
        this.totalUsd = totalUsd;
    }

    public Set<com.example.lab2_g5.WalletHasCurrencyWallet> getWalletHasCurrencyWallets() {
        return walletHasCurrencyWallets;
    }

    public void setWalletHasCurrencyWallets(Set<com.example.lab2_g5.WalletHasCurrencyWallet> walletHasCurrencyWallets) {
        this.walletHasCurrencyWallets = walletHasCurrencyWallets;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

}