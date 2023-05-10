package com.bunthong.dataanalyticsclass.repository;
import com.bunthong.dataanalyticsclass.model.Account;
import com.bunthong.dataanalyticsclass.model.User;
import com.bunthong.dataanalyticsclass.model.UserAccount;
import com.bunthong.dataanalyticsclass.model.request.UserRequest;
import com.bunthong.dataanalyticsclass.repository.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
//STEP 2
@Mapper
@Repository
public interface UserRepository {
    @Result(column = "id", property = "id")
//    @Select("Select * from users_tb")
    @SelectProvider(type = UserProvider.class, method = "getAllUsers")
    List<User> allUsers(String filterName);

    @Result(column = "id", property = "id")
    @Select("select * from users_tb where id = 1")
    List<User> findUserByUsername();

    @Result(column = "id", property = "id")
    @Insert("insert into users_tb(username, gender, address)\n" +
            "values (#{user.username}, #{user.gender},#{user.address})")
    int createNewUser(@Param("user") UserRequest user);
    @Update("update users_tb set username = (#{user.username},\n " +
            " gender = #{user.gender},\n" +
            " address = #{user.address}) where id ='1'")
    int updateUser(UserRequest user, @Param("id") int id);

    @Select("select * from users_tb where id = #{id}")
    User findUserByID(int id);

    @Delete("Delete from users_tb where id = #{id}")
    int removeUser(int id);


    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "accounts" , many = @Many(select = "findAccountByUserID"))
    })

    @Select("select * from users_tb")
    List<UserAccount> getAllUserAccounts();

    @Results({
            // if we named the variable the same as name columns name database, we don't have to declare it again in @Result, but if the name aren't the same we have to
//            @Result(property = "accountName", column = "account_name"),
//            @Result(property = "accountNumber", column = "account_no"),
//            @Result(property = "transferLimit", column = "transfer_limit"),
//            @Result(property = "password", column = "passcode"),
            @Result(property = "accountType", column = "account_type",
            one = @One(select = "com.bunthong.dataanalyticsclass.repository.AccountRepository.getAccountTypeByID"))
    })
    @Select("select * from useraccount_tb\n" +
            "  inner join account_tb a on a.id = useraccount_tb.account_id\n" +
            "          where user_id = #{id};")



    List<Account> findAccountByUserID(int id);
}
