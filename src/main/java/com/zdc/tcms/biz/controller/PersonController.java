package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.entity.User;
import com.zdc.tcms.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        User user = userService.getPictureAddress(username);
        mv.addObject("user", user);
        mv.setViewName("person");
        return mv;
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updateMessage")
    public String updateMessage(@RequestParam("username") String username, @RequestParam("gender") String gender,
                                @RequestParam("oldname") String oldname, HttpServletRequest request){
        boolean updateNameAndSex = userService.isUpdateNameAndSex(username, gender, oldname);
        if(updateNameAndSex == true){
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", username);
            return "success";
        }else {
            return "error";
        }
    }
}
