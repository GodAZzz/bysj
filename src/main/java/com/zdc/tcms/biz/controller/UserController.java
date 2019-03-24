package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.entity.User;
import com.zdc.tcms.biz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/getUserById")
    public User getUserById(String username,String password){
        return userMapper.getUserByLogin(username,password);
    }


}
