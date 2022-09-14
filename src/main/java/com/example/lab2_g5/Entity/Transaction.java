package com.example.lab2_g5.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idtransaction")
    private int idtransaction;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "tx_id")
    private String txId;
    @Basic
    @Column(name = "amount")
    private double amount;
    @Basic
    @Column(name = "neetwork_fee")
    private double neetworkFee;
    @Basic
    @Column(name = "block")
    private int block;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "currency")
    private String currency;
    @Basic
    @Column(name = "user_iduser")
    private int userIduser;
    @Basic
    @Column(name = "wallet_from")
    private int walletFrom;

    public int getIdtransaction() {
        return idtransaction;
    }

    public void setIdtransaction(int idtransaction) {
        this.idtransaction = idtransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getNeetworkFee() {
        return neetworkFee;
    }

    public void setNeetworkFee(double neetworkFee) {
        this.neetworkFee = neetworkFee;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(int userIduser) {
        this.userIduser = userIduser;
    }

    public int getWalletFrom() {
        return walletFrom;
    }

    public void setWalletFrom(int walletFrom) {
        this.walletFrom = walletFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return idtransaction == that.idtransaction && Double.compare(that.amount, amount) == 0 && Double.compare(that.neetworkFee, neetworkFee) == 0 && block == that.block && userIduser == that.userIduser && walletFrom == that.walletFrom && Objects.equals(description, that.description) && Objects.equals(txId, that.txId) && Objects.equals(status, that.status) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtransaction, description, txId, amount, neetworkFee, block, status, currency, userIduser, walletFrom);
    }
}
