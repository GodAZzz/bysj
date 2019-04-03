package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 个人中心
 */
@RestController
public class PersonController {

    /**
     * 跳转到个人中心界面
     */
    @RequestMapping(value = "/toPerson")
    public ModelAndView toPerson(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("person");
        return mv;
    }
}
