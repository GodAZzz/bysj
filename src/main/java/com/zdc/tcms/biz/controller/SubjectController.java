package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 专题
 */
@RestController
public class SubjectController {

    /**
     * 跳转到专题界面
     */
    @RequestMapping(value = "/toSubject")
    public ModelAndView toSubject(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("subject");
        return mv;
    }
}
