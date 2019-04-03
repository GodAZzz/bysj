package com.zdc.tcms.biz.service;

public interface UserService {

    boolean isLoginUser(String username, String password);

    boolean checkAccountExit(String username);

    boolean checkPhoneExit(String phone);

    boolean insertUser(String username, String userpwd, String phone);
}
