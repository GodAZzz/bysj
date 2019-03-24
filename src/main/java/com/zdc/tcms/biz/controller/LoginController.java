package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 登陆功能
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userLogin")
    public ModelAndView userLogin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("uname") String uname, @RequestParam("upwd") String upwd,
                              HttpSession session){
        ModelAndView mv = new ModelAndView();
        if(!StringUtils.isEmpty(uname) && !StringUtils.isEmpty(upwd)){
            boolean isLogin = userService.isLoginUser(uname, upwd);
            if(isLogin == true){
                //登录成功
                session.setAttribute("loginUser", uname);
                mv.setViewName("redirect:/index");
                return mv;
            }else {
                //登录失败
                mv.addObject("msg", "用户名或者密码错误");
                mv.setViewName("login");
                return mv;
            }
        }else{
            //登录失败
            mv.addObject("msg", "用户名或者密码错误");
            mv.setViewName("login");
            return mv;
        }
    }
}
