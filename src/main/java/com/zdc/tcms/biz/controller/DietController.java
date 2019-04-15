package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 膳食
 */
@RestController
public class DietController {

    /**
     * 跳转到膳食界面
     */
    @RequestMapping(value = "/toDiet")
    public ModelAndView toDiet(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("diet");
        return mv;
    }
}
