package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 个人中心
 */
@RestController
public class PersonController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到个人中心界面
     */
    @RequestMapping(value = "/toPerson")
    public ModelAndView toPerson(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("loginUser");
        String pictureAddress = userService.getPictureAddress(username);
        mv.addObject("pictureAddress", pictureAddress);
        mv.setViewName("person");
        return mv;
    }
}
