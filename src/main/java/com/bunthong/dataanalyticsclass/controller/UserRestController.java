package com.bunthong.dataanalyticsclass.controller;

import com.bunthong.dataanalyticsclass.model.User;
import com.bunthong.dataanalyticsclass.model.UserAccount;
import com.bunthong.dataanalyticsclass.model.request.UserRequest;
import com.bunthong.dataanalyticsclass.service.UserService;
import com.bunthong.dataanalyticsclass.utils.Response;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public Response<User> findUserByID(@PathVariable int id)
    {
        try {
            User response = userService.findUserByID(id);
            if(response!=null)
            {
                return Response.<User>ok().setPayload(response).setSuccess(true).setMessage(id+"is here...!");
            }
            else
            {
                return Response.<User>notFound().setMessage(id+" not existed!").setSuccess(false);
            }

        }catch (Exception e)
        {
            return Response.<User>exception().setMessage(id+" not existed!");
        }

    }


    @PostMapping("/new-user")
    public Response<User> createUser( @Valid @RequestBody UserRequest request){
        try {
            int affectedRow = userService.createNewUser(request);
            if(affectedRow > 0){
                User response = new User().setUsername(request.getUsername()).setAddress(request.getAddress()).setGender(request.getGender());
                return Response.<User>ok().setPayload(response).setMessage("User was created!");
            }else{
                return Response.<User>badRequest().setMessage("Bad Request failed!");
            }

        }catch (Exception exception){
            return Response.<User>exception().setMessage("Exception occurs! failed to create a new user ").setSuccess(false);
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

    // method for update the user
    @PutMapping ("/{id}")
    public Response<User> updateUserByID (@PathVariable("id") int id, @RequestBody UserRequest request){
        try {
            int result= userService.updateUser(request,id);
            if(result>0) {
                User response = new User().setId(id).setUsername(request.getUsername()).setGender(request.getGender()).setAddress(request.getAddress());
                return Response.<User>updateSuccess().setPayload(response).setMessage("update successfully.");
            }else {
                return Response.<User>ok().setMessage("user with "+id+" not found").setSuccess(false);
            }
        }catch (Exception e){
            System.out.println("error:"+e);
            return Response.<User>exception().setMessage("Update Fail.").setSuccess(false);
        }
    }

    //delete user account
    @DeleteMapping("/{id}")
    public Response<?> deleteUser (@PathVariable int id){
        try {
            int affectedRow = userService.removeUser(id);
            if(affectedRow>0){
                // delete success
                return Response.<Object>deleteSuccess().setMessage("Successfully remove the user !").setSuccess(true);
            }else{
                // id do not exist !
                return Response.<Object>notFound().setMessage("User with id ="+id+ " doesn't exitst in our system !");
            }
        }catch (Exception exception) {
            return Response.<Object>exception().setMessage("Exception occurred! Failed to delete the user !").setSuccess(false);
        }
    }


}
