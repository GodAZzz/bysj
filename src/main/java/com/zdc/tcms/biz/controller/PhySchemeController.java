package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 体质养生方案
 */
@RestController
public class PhySchemeController {

    /**
     * 跳转到体质养生方案界面
     * @return
     */
    @RequestMapping(value = "/toPhyScheme")
    public ModelAndView toPhyScheme(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("phy_scheme");
        return mv;
    }
}
