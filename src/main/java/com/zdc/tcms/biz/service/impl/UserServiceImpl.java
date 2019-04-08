package com.zdc.tcms.biz.service.impl;

import com.zdc.core.utils.IdWorker;
import com.zdc.tcms.biz.entity.User;
import com.zdc.tcms.biz.mapper.UserMapper;
import com.zdc.tcms.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Override
    public boolean checkAccountExit(String username) {
        User user = userMapper.checkAccountExit(username);
        if(user == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean checkPhoneExit(String phone) {
        User user = userMapper.phoneCheckExit(phone);
        if(user == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean insertUser(String username, String userpwd, String phone) {
        User user = new User();
        user.setUserid(new IdWorker().nextId());
        user.setUsername(username);
        user.setPassword(userpwd);
        user.setPhone(phone);
        user.setCreatetime(new Date());
        user.setStatus(0);
        int i = userMapper.insertUser(user);
        System.out.println(i);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User getPictureAddress(String username) {
        User user = userMapper.checkAccountExit(username);
        String pictureaddress = user.getPictureaddress();
        String gender = user.getGender();
        String tzlx = user.getTzlx();
        if("".equals(pictureaddress)){
            user.setPictureaddress("http://ppfqedo90.bkt.clouddn.com/person.jpg");
        }
        if("".equals(gender)){
            user.setGender("待完善");
        }
        if(tzlx == null){
            user.setTzlx("待完善");
        }
        return user;
    }

    @Override
    public boolean isUpdatePwd(String upwd, String uname) {
        int i = userMapper.updatePwd(upwd, uname);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isUpdateNameAndSex(String username, String gender, String oldname) {
        int i = userMapper.updateNameAndSex(username, gender, oldname);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Long getUserid(String username) {
        User user = userMapper.checkAccountExit(username);
        Long userid = user.getUserid();
        return userid;
    }


}
