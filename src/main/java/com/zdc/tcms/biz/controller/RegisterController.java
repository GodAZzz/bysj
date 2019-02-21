package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注册
 */
@RestController
public class RegisterController {

    @RequestMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }
}
