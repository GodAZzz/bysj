package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ArticleController {

    @RequestMapping(value = "/toArticle")
    public ModelAndView toArticle(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("article");
        return mv;
    }
}
