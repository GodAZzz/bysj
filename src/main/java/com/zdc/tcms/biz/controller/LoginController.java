package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登陆功能
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 用户登陆界面
     * @return
     */
    @RequestMapping(value = "/userLogin")
    public ModelAndView userLogin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    /**
     * 用户登陆
     * @param uname
     * @param upwd
     * @param session
     * @return
     */
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

    /**
     * 注销用户
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        //获取当前session
        HttpSession session = request.getSession();
        if(session != null){
            session.invalidate();
            mv.setViewName("login");
        }
        return mv;
    }
}
