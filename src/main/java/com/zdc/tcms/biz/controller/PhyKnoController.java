package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 体质知识
 */
@RestController
public class PhyKnoController {

    /**
     * 跳转到体质知识界面
     */
    @RequestMapping(value = "/toPhyKno")
    public ModelAndView toPhyKno(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("phy_kno");
        return mv;
    }
}
