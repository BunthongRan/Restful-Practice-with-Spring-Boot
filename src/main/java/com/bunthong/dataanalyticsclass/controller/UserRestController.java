package com.bunthong.dataanalyticsclass.controller;

import com.bunthong.dataanalyticsclass.model.User;
import com.bunthong.dataanalyticsclass.model.UserAccount;
import com.bunthong.dataanalyticsclass.service.UserService;
import com.bunthong.dataanalyticsclass.utils.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
//STEP 4
public class UserRestController {

    //inject userService

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all-users")
    List<User> getAllUser()
    {
        return userService.allUser();
    }

    @GetMapping("/find-id")
    List<User> getUserbyId(){
        return userService.findUserByName();
    }


    @PostMapping("/new-user")
    public String createUser(@RequestBody User user){
        try{
            int affectRow = userService.createNewUser(user);
            if(affectRow>0)
                return "Create user successfully!";
            else
                return "Cannot create a new user!!";
        } catch (Exception exception){
            return exception.getMessage();
        }

    }


    @GetMapping("/user-accounts")
    public Response<List<UserAccount>> getAllUserAccounts(){
        try{
            List<UserAccount> data = userService.getAllUserAccounts();
            return Response.<List<UserAccount>>ok().setPayload(data).setMessage("Successfully retrieved all user accounts !" );

        }catch (Exception exception){
            System.out.println("Error getting all account of user : "+ exception.getMessage());
            return Response.<List<UserAccount>>exception().setMessage("Exception occurs ! Failed to retrieved all user accounts! ").setSuccess(false);
        }
    }


}
