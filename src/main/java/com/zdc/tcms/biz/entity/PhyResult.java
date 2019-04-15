package com.zdc.tcms.biz.entity;

/**
 *结果实体类
 */
public class PhyResult {
    private Long resultid;

    private Long userid;

    private String question;

    private Integer grades;

    private Long parentid;

    public Long getResultid() {
        return resultid;
    }

    public void setResultid(Long resultid) {
        this.resultid = resultid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getGrades() {
        return grades;
    }

    public void setGrades(Integer grades) {
        this.grades = grades;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }
}
