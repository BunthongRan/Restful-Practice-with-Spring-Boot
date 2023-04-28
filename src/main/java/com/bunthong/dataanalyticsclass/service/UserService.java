package com.bunthong.dataanalyticsclass.service;

import com.bunthong.dataanalyticsclass.model.User;
import com.bunthong.dataanalyticsclass.model.UserAccount;
import com.bunthong.dataanalyticsclass.model.request.UserRequest;

import java.util.List;

//STEP 5
public interface UserService {
    List<User> allUser();
    List<User> findUserByName();
    User findUserByID(int id);

    int createNewUser(UserRequest user);
    int updateUser(UserRequest user,int id);
    int removeUser(int id);



    List<UserAccount> getAllUserAccounts();
}
