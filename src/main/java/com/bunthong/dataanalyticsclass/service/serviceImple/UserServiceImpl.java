package com.bunthong.dataanalyticsclass.service.serviceImple;

import com.bunthong.dataanalyticsclass.model.User;
import com.bunthong.dataanalyticsclass.model.UserAccount;
import com.bunthong.dataanalyticsclass.model.request.UserRequest;
import com.bunthong.dataanalyticsclass.repository.UserRepository;
import com.bunthong.dataanalyticsclass.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.coyote.Request;
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
    public PageInfo<User> allUser(int page, int size, String filterName) {
        // PageHelper
        PageHelper.startPage(page, size);
        return new PageInfo<>(userRepository.allUsers(filterName));
//        return userRepository.allUsers();
    }

    @Override
    public List<User> findUserByName() {
        return userRepository.findUserByUsername();
    }

    @Override
    public User findUserByID(int id) {

        return userRepository.findUserByID(id);
    }

    @Override
    public int createNewUser(UserRequest request) {
        return userRepository.createNewUser(request);
    }

    @Override
    public int updateUser(UserRequest user,int id) {
        return userRepository.updateUser(user,id);
    }

    @Override
    public int removeUser(int id) {
        return userRepository.removeUser(id);
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userRepository.getAllUserAccounts();
    }
}
