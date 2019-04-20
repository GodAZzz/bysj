package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.entity.Article;
import com.zdc.tcms.biz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/toArticle")
    public ModelAndView toArticle(@RequestParam("topic") String topic){
        ModelAndView mv = new ModelAndView();
        Article byTopic = articleService.getByTopic(topic);
        mv.addObject("article", byTopic);
        mv.setViewName("article");
        return mv;
    }
}
