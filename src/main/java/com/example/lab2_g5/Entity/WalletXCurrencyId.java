package com.example.lab2_g5.Entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WalletXCurrencyId implements Serializable {
    private static final long serialVersionUID = 6356733904259447932L;
    @Column(name = "currency_idcurrency", nullable = false)
    private Integer currencyIdcurrency;

    @Column(name = "wallet_idwallet", nullable = false)
    private Integer walletIdwallet;

    public Integer getCurrencyIdcurrency() {
        return currencyIdcurrency;
    }

    public void setCurrencyIdcurrency(Integer currencyIdcurrency) {
        this.currencyIdcurrency = currencyIdcurrency;
    }

    public Integer getWalletIdwallet() {
        return walletIdwallet;
    }

    public void setWalletIdwallet(Integer walletIdwallet) {
        this.walletIdwallet = walletIdwallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WalletXCurrencyId entity = (WalletXCurrencyId) o;
        return Objects.equals(this.currencyIdcurrency, entity.currencyIdcurrency) &&
                Objects.equals(this.walletIdwallet, entity.walletIdwallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyIdcurrency, walletIdwallet);
    }

}