package com.example.lab2_g5.Repository;

import com.example.lab2_g5.Entity.MyWalletDTO;
import com.example.lab2_g5.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByTxId(String id);

    @Query(nativeQuery = true,
    value = "SELECT * FROM transaction where tx_id like %?1%")
    List<Transaction> buscarPorTxId(String text);
    List<Transaction> findAll();

    @Query(nativeQuery = true,
    value = "select t.tx_id,t.currency,wc.purchase_price,wc.amount\n" +
            "from transaction t inner join wallet w\n" +
            "on (t.wallet_from=w.idwallet) inner join wallet_has_currency_wallet wc\n" +
            "on (wc.wallet_idwallet=w.idwallet) where t.user_iduser=?1")
    List<MyWalletDTO> TxPersonal(Integer id);
}
