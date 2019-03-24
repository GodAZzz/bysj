package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 中医
 */
@RestController
public class Tranditional {

    @RequestMapping(value = "/jumpToTranditional")
    public ModelAndView jumpToTranditional(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("traditional");
        return mv;
    }
}
