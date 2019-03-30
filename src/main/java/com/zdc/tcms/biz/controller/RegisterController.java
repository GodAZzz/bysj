package com.zdc.tcms.biz.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.zdc.core.utils.AliyunSmsUtils;
import com.zdc.core.utils.IdWorker;
import com.zdc.tcms.biz.entity.User;
import com.zdc.tcms.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 注册
 */
@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    /**
     * 点击注册按钮
     * @param username
     * @param userpwd
     * @param ruserpwd
     * @param phone
     * @param code
     * @return
     */
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String userRegister(@RequestParam("username") String username, @RequestParam("userpwd") String userpwd,
                                     @RequestParam("ruserpwd") String ruserpwd, @RequestParam("phone")String phone,
                                     @RequestParam("code") String code, HttpSession session){
        String result = "";
        if(session.getAttribute("yzm") == null){
            result = "error";
            return result;
        }
        if(session.getAttribute("yzm").toString().equals(code)){
            boolean isInsert = userService.insertUser(username,userpwd,phone);
            if(isInsert == true){
                result = "success";

            }else {
                result = "error";
            }
        }
        return result;
    }

    /**
     * 检验username是否已存在
     * @param username
     * @return
     */
    @RequestMapping(value = "/register/checkAccountExit")
    public String checkAccountExit(String username){
        String result = "";
        boolean isAccountExit = userService.checkAccountExit(username);
        if(isAccountExit == true){
            result = "账号已存在";
            return result;
        }else{
            result = "";
            return result;
        }
    }

    /**
     * 校验电话号码是否已被注册
     * @param phone
     * @return
     */
    @RequestMapping(value = "/register/phoneCheck")
    public String checkPhoneExit(String phone){
        boolean isPhoneExit = userService.checkPhoneExit(phone);
        String result = "";
        if(isPhoneExit == true){
            result = "号码已存在";
            return result;
        }else{
            result = "";
            return result;
        }
    }

    /**
     * 点击获取验证码
     */
    @RequestMapping(value = "/register/getPhoneCode")
    public String getPhoneCode(String phone, HttpSession session){
        String yzm = AliyunSmsUtils.getMessageCode();
        try {
            SendSmsResponse response = AliyunSmsUtils.sendSms(phone, yzm);
            System.out.println(response.getCode());
            session.setAttribute("yzm", yzm);
            return response.getCode();
        } catch (ClientException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
