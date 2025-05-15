package com.wallet.service;

import com.wallet.model.Transaction;
import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    void saveTransaction(Transaction transaction);
    double getCurrentBalance();
}
