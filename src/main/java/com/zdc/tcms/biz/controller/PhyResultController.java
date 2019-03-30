package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试结果
 */
@RestController
public class PhyResultController {

    /**
     * 跳转到测试结果界面
     */
    @RequestMapping(value = "/toPhyResult")
    public ModelAndView toPhyResult(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("phy_result");
        return mv;
    }
}
