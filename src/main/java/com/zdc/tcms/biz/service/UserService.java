package com.zdc.tcms.biz.service;

import com.zdc.tcms.biz.entity.User;

public interface UserService {

    boolean isLoginUser(String username, String password);

    boolean checkAccountExit(String username);

    boolean checkPhoneExit(String phone);

    boolean insertUser(String username, String userpwd, String phone);

    String getPictureAddress(String username);

    boolean isUpdatePwd(String upwd, String uname);
}
