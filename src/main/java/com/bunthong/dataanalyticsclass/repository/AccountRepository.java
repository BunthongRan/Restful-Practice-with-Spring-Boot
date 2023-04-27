package com.bunthong.dataanalyticsclass.repository;

import com.bunthong.dataanalyticsclass.model.Account;
import com.bunthong.dataanalyticsclass.model.AccountType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
@Repository
public interface AccountRepository {

    @Results({
            @Result(column = "account_type", property = "accountType" , one = @One(select = "getAccountTypeByID"))
    })
    @Select("select * from account_tb")
    List<Account> getAllAccounts();

    @Select("select * from accounttypes_tb where id = #{account_type}")
    AccountType getAccountTypeByID(int account_type);
    int createAccount(Account account);
    int updateAccount(Account account, int id);
    Account findAccountByID(int id);
}
