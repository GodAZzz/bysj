package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.entity.RecipesDetails;
import com.zdc.tcms.biz.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 膳食
 */
@RestController
public class FoodDetailsController {

    @Autowired
    private FoodService foodService;

    /**
     * 跳转到膳食食谱界面
     */
    @RequestMapping(value = "/toFoodDetails")
    public ModelAndView toFoodDetails(@RequestParam("foodname") String foodname){
        ModelAndView mv = new ModelAndView();
        RecipesDetails byFoodname = foodService.getByFoodname(foodname);
        mv.addObject("food",byFoodname);
        mv.setViewName("foodDetails");
        return mv;
    }
}
