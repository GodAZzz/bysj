package com.zdc.tcms.biz.controller;

import com.zdc.core.utils.PageBean;
import com.zdc.tcms.biz.entity.PhyTest;
import com.zdc.tcms.biz.entity.PhyTzlx;
import com.zdc.tcms.biz.mapper.PhyTestMapper;
import com.zdc.tcms.biz.service.PhyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *体质测试
 */
@RestController
public class PhyTestController {

    @Autowired
    private PhyTestService phyTestService;

    /**
     * 跳转到体质测试界面
     */
    @RequestMapping(value = "/toPhyTest")
    public ModelAndView toPhyTest(@RequestParam(value = "currentPage" , defaultValue = "1")int currentPage,
                                  @RequestParam(value = "pageSize" , defaultValue = "1")int pageSize){
        ModelAndView mv = new ModelAndView();
        PageBean phyTestByPage = phyTestService.findPhyTestByPage(currentPage, pageSize);
        mv.addObject("pageInfo", phyTestByPage);
        mv.setViewName("phy_test");
        return mv;
    }


    /*@RequestMapping(value = "/toPhyTest")
    public ModelAndView toPhyTest(@RequestParam(value = "count" , defaultValue = "0")int count){
        List<PhyTest> phyTestByParent = null;
        List<PhyTzlx> allTzlx = phyTestService.getAllTzlx();
        for(int i = 0;i < 8;i++){
            phyTestByParent = phyTestService.getPhyTestByParent(allTzlx.get(i).getTestid());
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("phyTest", phyTestByParent);
        mv.setViewName("phy_test");
        return mv;
    }*/

    /**
     * 将问题和值保持到数据库
     */
    @RequestMapping(value = "/savePhyTest")
    public String savePhyTest(@RequestParam("grade") int grade, @RequestParam("question") String question,
                              @RequestParam("parentid") long parentid,
                              HttpServletRequest request) {
        HttpSession session = request.getSession();
        String loginUser = (String) session.getAttribute("loginUser");
        int i = 0;
        i = phyTestService.insertOrUpdateResult(grade, question, loginUser,parentid);
        if (i > 0){
            return "success";
        }else {
            return "error";
        }
    }

    /**
     * 计算体质
     */
}
