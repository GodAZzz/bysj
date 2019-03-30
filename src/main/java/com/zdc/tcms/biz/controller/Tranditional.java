package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 中医
 */
@RestController
public class Tranditional {

    /**
     * 跳转到中医界面
     * @return
     */
    @RequestMapping(value = "/jumpToTranditional")
    public ModelAndView jumpToTranditional(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("traditional");
        return mv;
    }
}
