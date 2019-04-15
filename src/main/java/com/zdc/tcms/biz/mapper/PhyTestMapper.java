package com.zdc.tcms.biz.mapper;

import com.zdc.tcms.biz.entity.PhyGrades;
import com.zdc.tcms.biz.entity.PhyResult;
import com.zdc.tcms.biz.entity.PhyTest;
import com.zdc.tcms.biz.entity.PhyTzlx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhyTestMapper {

    /**
     *查找全部问题
     */
    List<PhyTest> findAll();

    /**
     * 查找总记录数
     */
    int findCountNums();

    List<PhyTzlx> getAllTzlx();

    List<PhyTest> getPhyTestByParent(@Param("parentid")long parentid);

    int insertResult(PhyResult phyResult);

    PhyResult getByUserAndQuestion(@Param("userid")long userid, @Param("question")String question);

    int updateGrade(@Param("userid")long userid, @Param("question")String question, @Param("grades")double grades);

    List<PhyResult> getPhyResultByParent(@Param("parentid")long parentid);

    int insertGrades(PhyGrades phyGrades);

    PhyGrades getByUserAndtzlx(@Param("userid")long userid, @Param("tzlx")String tzlx);

    int updateGrades(@Param("userid")long userid, @Param("tzlx")String tzlx, @Param("grade")double grade);

    List<PhyGrades> getAllGradesByUser(@Param("userid")long userid);
}
