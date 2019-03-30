package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 食物库
 */
@RestController
public class FoodLibController {

    /**
     * 跳转到食物库界面
     * @return
     */
    @RequestMapping(value = "/toFoodLib")
    public ModelAndView toFoodLib(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("foodLib");
        return mv;
    }
}
