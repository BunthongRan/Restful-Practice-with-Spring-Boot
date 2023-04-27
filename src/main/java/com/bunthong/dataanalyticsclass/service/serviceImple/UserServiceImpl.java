package com.bunthong.dataanalyticsclass.service.serviceImple;

import com.bunthong.dataanalyticsclass.model.User;
import com.bunthong.dataanalyticsclass.model.UserAccount;
import com.bunthong.dataanalyticsclass.repository.UserRepository;
import com.bunthong.dataanalyticsclass.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

//STEP 6
@Service
public class UserServiceImpl implements UserService {
    //inject repository

    UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository= userRepository;
    }

    @Override
    public List<User> allUser() {
        return userRepository.allUsers();
    }

    @Override
    public List<User> findUserByName() {
        return userRepository.findUserByUsername();
    }

    @Override
    public User findUserByID(int id) {
        return null;
    }

    @Override
    public int createNewUser(User user) {
        return userRepository.createNewUser(user);
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int removeUser(int id) {
        return 0;
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userRepository.getAllUserAccounts();
    }
}
