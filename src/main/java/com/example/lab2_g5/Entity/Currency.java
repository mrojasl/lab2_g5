package com.example.lab2_g5.Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @Column(name = "idcurrency", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "description", nullable = false, length = 400)
    private String description;

    @Column(name = "network", nullable = false, length = 45)
    private String network;

    @Column(name = "abbreviation", nullable = false, length = 45)
    private String abbreviation;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToMany(mappedBy = "currency")
    private Set<com.example.lab2_g5.WalletHasCurrencyWallet> walletHasCurrencyWallets = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<com.example.lab2_g5.WalletHasCurrencyWallet> getWalletHasCurrencyWallets() {
        return walletHasCurrencyWallets;
    }

    public void setWalletHasCurrencyWallets(Set<com.example.lab2_g5.WalletHasCurrencyWallet> walletHasCurrencyWallets) {
        this.walletHasCurrencyWallets = walletHasCurrencyWallets;
    }

}