package com.omertursun.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoRefreshToken {

    private Long id;
    private String refreshToken;
    private String expiryDate;
    private DtoUser dtoUser;

}
