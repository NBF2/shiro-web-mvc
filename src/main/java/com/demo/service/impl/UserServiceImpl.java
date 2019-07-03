package com.demo.service.impl;

import com.demo.common.pojo.UserBean;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService  {

    @Autowired
    private UserMapper userMapper;


    public String getPasswordByUserName(String username) {
        UserBean userBean = userMapper.getUserByUserName(username);
        return userBean.getPassword();
    }
}
