package com.zdc.tcms.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.zdc.core.utils.IdWorker;
import com.zdc.core.utils.PageBean;
import com.zdc.tcms.biz.entity.PhyGrades;
import com.zdc.tcms.biz.entity.PhyResult;
import com.zdc.tcms.biz.entity.PhyTest;
import com.zdc.tcms.biz.entity.PhyTzlx;
import com.zdc.tcms.biz.mapper.PhyTestMapper;
import com.zdc.tcms.biz.mapper.UserMapper;
import com.zdc.tcms.biz.service.PhyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhyTestServiceImpl implements PhyTestService {

    @Autowired
    private PhyTestMapper phyTestMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageBean findPhyTestByPage(int currentPage, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数
        PageHelper.startPage(currentPage, pageSize);
        //全部问题
        List<PhyTest> allQuestion = phyTestMapper.findAll();
        //总记录数
        int countNums = phyTestMapper.findCountNums();
        PageBean<PhyTest> phyTestPageBean = new PageBean<PhyTest>(currentPage, pageSize, countNums);
        phyTestPageBean.setItems(allQuestion);
        return phyTestPageBean;
    }

    @Override
    public List<PhyTzlx> getAllTzlx() {
        List<PhyTzlx> allTzlx = phyTestMapper.getAllTzlx();
        return allTzlx;
    }

    @Override
    public List<PhyTest> getPhyTestByParent(long parentid) {
        List<PhyTest> phyTestByParent = phyTestMapper.getPhyTestByParent(parentid);
        return phyTestByParent;
    }

    @Override
    public int insertOrUpdateResult(int grade, String question, String loginUser, long parentid) {
        Long userid = userMapper.checkAccountExit(loginUser).getUserid();
        PhyResult byUserAndQuestion = phyTestMapper.getByUserAndQuestion(userid, question);
        int i = 0;
        if(byUserAndQuestion == null){
            PhyResult phyResult = new PhyResult();
            phyResult.setResultid(new IdWorker().nextId());
            phyResult.setUserid(userid);
            phyResult.setQuestion(question);
            phyResult.setGrades(grade);
            phyResult.setParentid(parentid);
            i = phyTestMapper.insertResult(phyResult);
        }else {
            i = phyTestMapper.updateGrade(userid, question, grade);
        }
        return i;
    }

    @Override
    public List<PhyResult> getPhyResultByParent(long parentid) {
        List<PhyResult> phyResultByParent = phyTestMapper.getPhyResultByParent(parentid);
        return phyResultByParent;
    }


    @Override
    public int insertOrUpdateGrades(String loginUser, String tzlx, double grade) {
        Long userid = userMapper.checkAccountExit(loginUser).getUserid();
        PhyGrades byUserAndtzlx = phyTestMapper.getByUserAndtzlx(userid, tzlx);
        int i = 0;
        if(byUserAndtzlx == null){
            PhyGrades phyGrades = new PhyGrades();
            phyGrades.setGradesid(new IdWorker().nextId());
            phyGrades.setUserid(userid);
            phyGrades.setTzlx(tzlx);
            phyGrades.setGrade(grade);
            i = phyTestMapper.insertGrades(phyGrades);
        }else {
            i = phyTestMapper.updateGrades(userid, tzlx, grade);
        }
        return i;
    }

    @Override
    public String getTz(String loginUser) {
        String result = null;
        Long userid = userMapper.checkAccountExit(loginUser).getUserid();
        List<PhyGrades> allGradesByUser = phyTestMapper.getAllGradesByUser(userid);
        Map<String,Double> tz = new HashMap<String,Double>();
        for(PhyGrades phyGrades : allGradesByUser){
            String tzlx = phyGrades.getTzlx();
            if("平和质".equals(tzlx)){
                tz.put("平和质", phyGrades.getGrade());
                continue;
            }
            if("阳虚质".equals(tzlx)){
                tz.put("阳虚质", phyGrades.getGrade());
                continue;
            }
            if("阴虚质".equals(tzlx)){
                tz.put("阴虚质", phyGrades.getGrade());
                continue;
            }
            if("气虚质".equals(tzlx)){
                tz.put("气虚质", phyGrades.getGrade());
                continue;
            }
            if("痰湿质".equals(tzlx)){
                tz.put("痰湿质", phyGrades.getGrade());
                continue;
            }
            if("湿热质".equals(tzlx)){
                tz.put("湿热质", phyGrades.getGrade());
                continue;
            }
            if("血瘀质".equals(tzlx)){
                tz.put("血瘀质", phyGrades.getGrade());
                continue;
            }
            if("特禀质".equals(tzlx)){
                tz.put("特禀质", phyGrades.getGrade());
                continue;
            }
            if("气郁质".equals(tzlx)){
                tz.put("气郁质", phyGrades.getGrade());
                continue;
            }
        }
        //判断是否为平和质
        if(tz.get("平和质") >= 60){
            int count = 0;
            for(Map.Entry<String, Double> entry : tz.entrySet()){

                if("平和质".equals(entry.getKey())){
                    continue;
                }
                if(entry.getValue() < 30){
                    count++;
                }

            }
            if (count == 8){
                result = "是平和质";
                return  result;
            }

                if(tz.get("阳虚质") >=30 && tz.get("阳虚质") < 40){
                    result = "基本是平和质,有阳虚质倾向";
                    return result;
                }
                if(tz.get("阴虚质") >=30 && tz.get("阴虚质") < 40){
                    result = "基本是平和质,有阴虚质倾向";
                    return result;
                }
                if(tz.get("气虚质") >=30 && tz.get("气虚质") < 40){
                    result = "基本是平和质,有气虚质倾向";
                    return result;
                }
                if(tz.get("痰湿质") >=30 && tz.get("痰湿质") < 40){
                    result = "基本是平和质,有痰湿质倾向";
                    return result;
                }
                if(tz.get("湿热质") >=30 && tz.get("湿热质") < 40){
                    result = "基本是平和质,有湿热质倾向";
                    return result;
                }
                if(tz.get("血瘀质") >=30 && tz.get("血瘀质") < 40){
                    result = "基本是平和质,有血瘀质倾向";
                    return result;
                }
                if(tz.get("特禀质") >=30 && tz.get("特禀质") < 40){
                    result = "基本是平和质,有特禀质倾向";
                    return result;
                }
                if(tz.get("气郁质") >=30 && tz.get("气郁质") < 40){
                    result = "基本是平和质,有气郁质倾向";
                    return result;
                }


        }else {
            if(tz.get("阳虚质") >=40){
                result = "是阳虚质";
                return result;
            }
            if(tz.get("阴虚质") >=40){
                result = "是阴虚质";
                return result;
            }
            if(tz.get("气虚质") >=40){
                result = "是气虚质";
                return result;
            }
            if(tz.get("痰湿质") >=40){
                result = "是痰湿质";
                return result;
            }
            if(tz.get("湿热质") >=40){
                result = "是湿热质";
                return result;
            }
            if(tz.get("血瘀质") >=40){
                result = "是血瘀质";
                return result;
            }
            if(tz.get("特禀质") >=40){
                result = "是特禀质";
                return result;
            }
            if(tz.get("气郁质") >=40){
                result = "是气郁质";
                return result;
            }
        }
        return result;
    }


}
