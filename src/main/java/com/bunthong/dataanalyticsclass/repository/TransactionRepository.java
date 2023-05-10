package com.bunthong.dataanalyticsclass.repository;

import com.bunthong.dataanalyticsclass.model.Transaction;
import com.bunthong.dataanalyticsclass.model.UserTransaction;
import com.bunthong.dataanalyticsclass.repository.provider.TransactionProvider;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TransactionRepository {
    @SelectProvider(type = TransactionProvider.class, method = "getTransactions")
    @Results({
            @Result(column = "sender_account-id", property = "sender", one = @One(select = "getUserTransactionByAccountID")),
            @Result(column = "receiver_account_id", property = "receiver", one = @One(select = "getUserTransactionByAccountID"))
    })
    List<Transaction> getAllTransactions();

   @Select("select a.id, ut.*, a.account_no from useraccount_tb\n" +
           "inner join users_tb ut on ut.id = useraccount_tb.user_id\n" +
           "inner join account_tb a on a.id = useraccount_tb.account_id\n" +
           "where account_id = #{id}")

   @Results(value = {
           @Result(property ="accountId", column ="account_id"),
           @Result(property = "accountNumber",column = "account_no"),
           @Result(property = "user.id", column = "id"),
           @Result(property = "user.username",column = "username"),
           @Result(property = "user.gender", column = "gender"),
           @Result(property = "user.address", column = "address")})

    UserTransaction getUserTransactionByAccountID(int id);

}
