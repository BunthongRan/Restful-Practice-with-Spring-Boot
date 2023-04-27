package com.bunthong.dataanalyticsclass.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
   private int id;
   private String account_no;
   private String account_name;
   private String profile;
//   private int pin;
//   private String password;
   private String phone_number;
   private int transfer_limit;
  // private int account_type;
   private AccountType accountType;
}