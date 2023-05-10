package com.bunthong.dataanalyticsclass.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserTransaction {
    private int accountId;
    private String accountNumber;
    private User user;
}
