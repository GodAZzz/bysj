package com.zdc.tcms.biz.entity;

/**
 * 用户每个体质得分
 */
public class PhyGrades {
    private Long gradesid;

    private Long userid;

    private String tzlx;

    private Double grade;

    public Long getGradesid() {
        return gradesid;
    }

    public void setGradesid(Long gradesid) {
        this.gradesid = gradesid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getTzlx() {
        return tzlx;
    }

    public void setTzlx(String tzlx) {
        this.tzlx = tzlx;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
