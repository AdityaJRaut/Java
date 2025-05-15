package com.wallet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.dao.TransactionDao;
import com.wallet.model.Transaction;
import com.wallet.service.TransactionService;
import com.wallet.exception.InsufficientBalanceException;
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionDao.getAll();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
    	 double currentBalance = getCurrentBalance();  // method that calculates balance

         // 🔥 This is where we check and throw the exception
         if ("DEBIT".equalsIgnoreCase(transaction.getType()) &&
             transaction.getAmount() > currentBalance) {

             throw new InsufficientBalanceException("Insufficient balance for this debit transaction.");
         }

         // ✅ If valid, save transaction
         transactionDao.save(transaction);
    }
    
   

    @Override
    public double getCurrentBalance() {
    	 List<Transaction> transactions = transactionDao.getAll();
    	    double balance = 0.0;

    	    for (Transaction t : transactions) {
    	        if ("CREDIT".equals(t.getType())) {
    	            balance += t.getAmount();
    	        } else if ("DEBIT".equals(t.getType())) {
    	            balance -= t.getAmount();
    	        }
    	    }

    	    return balance;
    }
}
