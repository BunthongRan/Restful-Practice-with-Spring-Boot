package com.bunthong.dataanalyticsclass.service;

import com.bunthong.dataanalyticsclass.model.Transaction;

import java.util.List;

public interface TransactionService {
    // feature of the applications
    List<Transaction> getAllTransactions();
    int createTransaction(Transaction transaction);
    int deleteTransaction(int transactionId);
    List<Transaction> getTransactionByUserId(int userId);


}
