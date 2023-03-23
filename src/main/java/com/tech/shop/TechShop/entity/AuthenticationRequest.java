package com.tech.shop.TechShop.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthenticationRequest {

    private String uname;
    String password;
}
