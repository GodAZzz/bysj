package com.zdc.tcms.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 膳食
 */
@RestController
public class FoodDetailsController {

    /**
     * 跳转到膳食界面
     */
    @RequestMapping(value = "/toFoodDetails")
    public ModelAndView toFoodDetails(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("foodDetails");
        return mv;
    }
}
