package com.tech.shop.TechShop.serviceImpl;

import com.tech.shop.TechShop.configs.Snippets;
import com.tech.shop.TechShop.entity.Role;
import com.tech.shop.TechShop.entity.User;
import com.tech.shop.TechShop.repository.UserRepository;
import com.tech.shop.TechShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findUserByUname(String uname) {
        return userRepository.findUserByUname(uname);
    }

    @Override
    public User saveNewUser(User user) {
            user.setId(UUID.randomUUID().toString());
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat(Snippets.TIME_PATTERN);
            user.setUpw(passwordEncoder.encode(user.getPassword()));
            user.setActive(false);
            user.setJoined_at(sdf.format(date));
            List<Role> roles =new ArrayList<>();
            roles.add(roleService.getRoleByName(Snippets.ROLE_USER));
            user.setRoles(roles);

            return userRepository.save(user);
    }


    @Override
    public User updateUser(User user) {
        User dataUser = userRepository.findUserByUname(user.getUname());

            if(user.getPassword() != null) {
                user.setUpw(passwordEncoder.encode(user.getPassword()));
                if (!user.getPassword().equals(dataUser.getPassword())) {
                    dataUser.setUpw(user.getPassword());
                }

            if(user.getProfile_image() != null && !user.getProfile_image().equals(dataUser.getProfile_image())){
                dataUser.setProfile_image(user.getProfile_image());
            }

            if(user.getName() != null){
                dataUser.setName(user.getName());
            }
        }
        return userRepository.save(dataUser);
    }

    @Override
    public List<User> getAllCustomer() {
        return null;
    }

    @Override
    public List<User> getAllEmployee() {
        return null;
    }


}
