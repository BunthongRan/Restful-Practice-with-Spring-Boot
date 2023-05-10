package com.bunthong.dataanalyticsclass.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int id;
//    private int senderAccountId ;
    private UserTransaction sender;
//    private int receiverAccountId;
    private UserTransaction receiver;
    private float amount;
    private String remark;
    private Timestamp transferAt;


}
