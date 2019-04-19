package com.zdc.tcms.biz.controller;

import com.zdc.core.utils.PageBean;
import com.zdc.tcms.biz.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 膳食分类
 */
@RestController
public class CategoryController {


    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/toCategory")
    public ModelAndView toCategory(@RequestParam(value = "currentPage" , defaultValue = "1")int currentPage,
                                   @RequestParam(value = "pageSize" , defaultValue = "3")int pageSize,
                                   @RequestParam(value = "fenlei") String fenlei){
        ModelAndView mv = new ModelAndView();
        PageBean recipesDetailsByPage = foodService.findRecipesDetailsByPage(currentPage, pageSize, fenlei);
        recipesDetailsByPage.setCondtion(fenlei);
        mv.addObject("recipesDetails", recipesDetailsByPage);
        mv.setViewName("category");
        return mv;
    }
}
