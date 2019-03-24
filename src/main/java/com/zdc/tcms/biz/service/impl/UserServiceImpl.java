package com.zdc.tcms.biz.service.impl;

import com.zdc.tcms.biz.entity.User;
import com.zdc.tcms.biz.mapper.UserMapper;
import com.zdc.tcms.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean isLoginUser(String username, String password) {
        User user = userMapper.getUserByLogin(username, password);
        if(user == null){
            return false;
        }else{
            return true;
        }

    }
}
