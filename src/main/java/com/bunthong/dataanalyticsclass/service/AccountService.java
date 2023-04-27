package com.bunthong.dataanalyticsclass.service;

import com.bunthong.dataanalyticsclass.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    int createAccount(Account account);
    int updateAccount(Account account, int id);

    Account findAccountById(int id);
}
