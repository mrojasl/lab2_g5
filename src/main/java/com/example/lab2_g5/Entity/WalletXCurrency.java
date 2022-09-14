package com.example.lab2_g5.Entity;

import javax.persistence.*;

@Entity
@Table(name = "wallet_has_currency_wallet")
public class WalletXCurrency {
    @EmbeddedId
    private WalletXCurrencyId id;

    @MapsId("currencyIdcurrency")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "currency_idcurrency", nullable = false)
    private Currency currencyIdcurrency;

    @MapsId("walletIdwallet")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wallet_idwallet", nullable = false)
    private Wallet walletIdwallet;

    @Column(name = "purchase_price", nullable = false)
    private Double purchasePrice;

    @Column(name = "amount", nullable = false)
    private Double amount;

    public WalletXCurrencyId getId() {
        return id;
    }

    public void setId(WalletXCurrencyId id) {
        this.id = id;
    }

    public Currency getCurrencyIdcurrency() {
        return currencyIdcurrency;
    }

    public void setCurrencyIdcurrency(Currency currencyIdcurrency) {
        this.currencyIdcurrency = currencyIdcurrency;
    }

    public Wallet getWalletIdwallet() {
        return walletIdwallet;
    }

    public void setWalletIdwallet(Wallet walletIdwallet) {
        this.walletIdwallet = walletIdwallet;
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