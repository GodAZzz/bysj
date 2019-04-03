package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 忘记密码
 */
@RestController
public class ForgetPwdController {

    /**
     * 跳转到忘记密码界面
     */
    @RequestMapping(value = "/toForgetPwd")
    public ModelAndView toForgetPwd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forgetPwd");
        return mv;
    }
}
