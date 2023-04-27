package com.bunthong.dataanalyticsclass.controller;

import com.bunthong.dataanalyticsclass.mapper.AutoAccountMapper;
import com.bunthong.dataanalyticsclass.model.Account;
import com.bunthong.dataanalyticsclass.model.response.AccountResponse;
import com.bunthong.dataanalyticsclass.service.AccountService;
import com.bunthong.dataanalyticsclass.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    //inject account service
    final private AccountService accountService;
    final private AutoAccountMapper autoAccountMapper;

    public AccountController(AccountService accountService, AutoAccountMapper autoAccountMapper) {
        this.accountService = accountService;
        this.autoAccountMapper = autoAccountMapper;
    }

    @GetMapping("/all-accounts")
    public Response<List<AccountResponse>> getAllAccounts(){
        try{
            List<Account> allAccount = accountService.getAllAccounts();
            List<AccountResponse> accountResponses = autoAccountMapper.mapToAccountResponse(allAccount);

            return Response.<List<AccountResponse>>ok().setPayload(accountResponses).setMessage("successfully retrieve all account information ");

        } catch (Exception exception){
            System.out.println("Something wrong: "+exception.getMessage());
            return Response.<List<AccountResponse>>exception().setMessage("Exception occurs! Failed to retrieve account information");
        }
    }
}
