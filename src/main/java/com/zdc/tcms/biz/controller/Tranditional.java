package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 中医
 */
@RestController
public class Tranditional {

    @Autowired
    private UserService userService;

    /**
     * 跳转到中医界面
     * @return
     */
    @RequestMapping(value = "/jumpToTranditional")
    public ModelAndView jumpToTranditional(HttpServletRequest request){
        HttpSession session = request.getSession();
        String loginUser = (String) session.getAttribute("loginUser");
        String gender = userService.getGenderByName(loginUser);
        System.out.println(gender);
        ModelAndView mv = new ModelAndView();
        mv.addObject("gender", gender);
        mv.setViewName("traditional");
        return mv;
    }
}
