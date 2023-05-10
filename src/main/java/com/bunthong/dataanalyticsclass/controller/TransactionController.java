package com.bunthong.dataanalyticsclass.controller;

import com.bunthong.dataanalyticsclass.model.Transaction;
import com.bunthong.dataanalyticsclass.service.TransactionService;
import com.bunthong.dataanalyticsclass.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    // inject service interface
    private final TransactionService transactionService;
    TransactionController(TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }


    //getAllTransaction
    @GetMapping("/all-transactions")
    public Response<List<Transaction>> getAllTransactions(){
        List<Transaction> transactions = transactionService.getAllTransactions();
        return Response.<List<Transaction>>ok().setPayload(transactions).setMessage("Successfully retrieved all the transaction");
    }



}
