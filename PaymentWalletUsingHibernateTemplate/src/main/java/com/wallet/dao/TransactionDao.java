package com.wallet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wallet.model.Transaction;

@Repository
public class TransactionDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    // Save a transaction
    @Transactional
    public void save(Transaction transaction) throws DataAccessException {
        hibernateTemplate.saveOrUpdate(transaction); // Save or Update the transaction
    }

    // Get all transactions
    @Transactional(readOnly = true)
    public List<Transaction> getAll() {
        return hibernateTemplate.loadAll(Transaction.class);
    }

    // Additional helper methods like finding by ID could be added here
    @Transactional(readOnly = true)
    public Transaction findById(Long id) {
        return hibernateTemplate.get(Transaction.class, id);
    }
}
