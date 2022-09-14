package com.example.lab2_g5.Entity;

import javax.persistence.*;

@Entity
@Table(name = "wallet_has_currency_wallet")
public class WalletXCurrency {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private WalletXCurrencyId id;

    @MapsId("walletIdwallet")
    @ManyToOne
    @JoinColumn(name = "wallet_idwallet", nullable = false)
    private Wallet walletIdwallet;

    @MapsId("currencyIdcurrency")
    @ManyToOne
    @JoinColumn(name = "currency_idcurrency", nullable = false)
    private Currency currencyIdcurrency;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "amount")
    private Double amount;

    public WalletXCurrencyId getId() {
        return id;
    }

    public void setId(WalletXCurrencyId id) {
        this.id = id;
    }

    public Wallet getWalletIdwallet() {
        return walletIdwallet;
    }

    public void setWalletIdwallet(Wallet walletIdwallet) {
        this.walletIdwallet = walletIdwallet;
    }

    public Currency getCurrencyIdcurrency() {
        return currencyIdcurrency;
    }

    public void setCurrencyIdcurrency(Currency currencyIdcurrency) {
        this.currencyIdcurrency = currencyIdcurrency;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}