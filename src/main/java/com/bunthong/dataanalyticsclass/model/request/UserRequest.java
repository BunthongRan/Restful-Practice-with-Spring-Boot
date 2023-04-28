package com.bunthong.dataanalyticsclass.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Accessors(chain = true)
public class UserRequest {
    private String username;
    private String gender;
    private String address;
}
