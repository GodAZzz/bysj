package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.entity.PhyResult;
import com.zdc.tcms.biz.entity.PhyTzlx;
import com.zdc.tcms.biz.service.PhyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 测试结果
 */
@RestController
public class PhyResultController {

    @Autowired
    PhyTestService phyTestService;

    /**
     * 计算结果,跳转到测试结果界面
     */
    @RequestMapping(value = "/toPhyResult")
    public ModelAndView toPhyResult(HttpServletRequest request){
        HttpSession session = request.getSession();
        String loginUser = (String) session.getAttribute("loginUser");
        List<PhyTzlx> allTzlx = phyTestService.getAllTzlx();
        for(PhyTzlx phyTzlx : allTzlx){
            int grades = 0;
            String tzlx = phyTzlx.getTzlx();
            List<PhyResult> phyResultByParent = phyTestService.getPhyResultByParent(phyTzlx.getTestid());
            for(int i = 0;i < phyResultByParent.size();i++){
                grades += phyResultByParent.get(i).getGrades();
            }
            double g = ((grades-phyTzlx.getAmount() * 1.0)/(phyTzlx.getAmount()*4))*100;
            phyTestService.insertOrUpdateGrades(loginUser, tzlx, g);
        }
        String tz = phyTestService.getTz(loginUser);
        System.out.println(tz);
        ModelAndView mv = new ModelAndView();
        mv.addObject("tz", tz);
        mv.setViewName("phy_result");
        return mv;
    }

}
