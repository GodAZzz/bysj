package com.zdc.tcms.biz.entity;

/**
 * 体质类型实体类
 */
public class PhyTzlx {

    private Long testid;

    private String tzlx;

    private Integer amount;

    public Long getTestid() {
        return testid;
    }

    public void setTestid(Long testid) {
        this.testid = testid;
    }

    public String getTzlx() {
        return tzlx;
    }

    public void setTzlx(String tzlx) {
        this.tzlx = tzlx;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
