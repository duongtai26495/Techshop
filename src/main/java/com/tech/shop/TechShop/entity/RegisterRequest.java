package com.tech.shop.TechShop.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegisterRequest {

    private String name;
    private String uname;
    private String email;
    private String password;
}
