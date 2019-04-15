package com.zdc.tcms.biz.service;

import com.zdc.tcms.biz.entity.User;

public interface UserService {

    boolean isLoginUser(String username, String password);

    boolean checkAccountExit(String username);

    boolean checkPhoneExit(String phone);

    boolean insertUser(String username, String userpwd, String phone);

    User getPictureAddress(String username);

    boolean isUpdatePwd(String upwd, String uname);

    boolean isUpdateNameAndSex(String username, String gender, String oldname);

    Long getUserid(String username);

    String getGenderByName(String username);
}
