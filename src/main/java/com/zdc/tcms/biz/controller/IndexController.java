package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.entity.Article;
import com.zdc.tcms.biz.entity.RecipesDetails;
import com.zdc.tcms.biz.service.ArticleService;
import com.zdc.tcms.biz.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *首页
 */
@RestController
public class IndexController {


    @Autowired
    private FoodService foodService;

    @Autowired
    private ArticleService articleService;

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        List<RecipesDetails> fourFood = foodService.getFourFood();
        List<Article> fiveArtice = articleService.getFiveArtice();
        mv.addObject("fourFood", fourFood);
        mv.addObject("articles",fiveArtice);
        mv.setViewName("index");
        return mv;
    }
}
