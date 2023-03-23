package com.tech.shop.TechShop.service;


import com.tech.shop.TechShop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    User findUserByUname(String uname);

    User saveNewUser(User user);

    User updateUser(User user);

    List<User> getAllCustomer();

    List<User> getAllEmployee();
}
