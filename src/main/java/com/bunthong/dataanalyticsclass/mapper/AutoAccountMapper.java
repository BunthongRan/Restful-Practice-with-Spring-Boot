package com.bunthong.dataanalyticsclass.mapper;

import com.bunthong.dataanalyticsclass.model.Account;
import com.bunthong.dataanalyticsclass.model.response.AccountResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface AutoAccountMapper {
    // account -> account-response
    List<AccountResponse> mapToAccountResponse(List<Account> accounts);

    // account-response -> account
    List<Account> mapToAccount(List<AccountResponse> accounts);


}
