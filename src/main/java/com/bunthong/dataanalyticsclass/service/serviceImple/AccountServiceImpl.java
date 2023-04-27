package com.bunthong.dataanalyticsclass.service.serviceImple;

import com.bunthong.dataanalyticsclass.model.Account;
import com.bunthong.dataanalyticsclass.repository.AccountRepository;
import com.bunthong.dataanalyticsclass.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    //inject repository
    private final AccountRepository accountRepository;
    AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public int createAccount(Account account) {
        return 0;
    }

    @Override
    public int updateAccount(Account account, int id) {
        return 0;
    }

    @Override
    public Account findAccountById(int id) {
        return accountRepository.findAccountByID(id) ;
    }

//    @Override
//    public Account findAccountById(int id) {
//        return accountRepository.findAccountByID(id);
//    }


}
