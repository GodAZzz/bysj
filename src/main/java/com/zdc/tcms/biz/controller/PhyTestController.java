package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *体质测试
 */
@RestController
public class PhyTestController {

    /**
     * 跳转到体质测试界面
     */
    @RequestMapping(value = "/toPhyTest")
    public ModelAndView toPhyTest(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("phy_test");
        return mv;
    }
}
