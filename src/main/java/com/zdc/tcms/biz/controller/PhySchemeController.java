package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PhySchemeController {

    @RequestMapping(value = "/toPhyScheme")
    public ModelAndView toPhyScheme(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("phy_scheme");
        return mv;
    }
}
