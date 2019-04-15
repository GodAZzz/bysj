package com.zdc.tcms.biz.service;

import com.zdc.core.utils.PageBean;
import com.zdc.tcms.biz.entity.PhyGrades;
import com.zdc.tcms.biz.entity.PhyResult;
import com.zdc.tcms.biz.entity.PhyTest;
import com.zdc.tcms.biz.entity.PhyTzlx;

import java.util.List;

/**
 * 体质测试
 */
public interface PhyTestService {

    /**
     * 分页查询题目
     */
    PageBean findPhyTestByPage(int currentPage, int pageSize);

    List<PhyTzlx> getAllTzlx();

    List<PhyTest> getPhyTestByParent(long parentid);

    int insertOrUpdateResult(int grade, String question, String loginUser, long parentid);

    List<PhyResult> getPhyResultByParent(long parentid);

    int insertOrUpdateGrades(String loginUser, String tzlx, double grade);

    String getTz(String loginUser);
}
