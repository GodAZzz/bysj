package com.zdc.tcms.biz.entity;

/**
 * 食谱实体类
 */
public class RecipesDetails {

    private Long recipesdetailid;

    private String fenlei;

    private String foodname;

    private String pictureaddress;

    private String introduce;

    private String shicai;

    private String method;

    private String notice;

    public Long getRecipesdetailid() {
        return recipesdetailid;
    }

    public void setRecipesdetailid(Long recipesdetailid) {
        this.recipesdetailid = recipesdetailid;
    }

    public String getFenlei() {
        return fenlei;
    }

    public void setFenlei(String fenlei) {
        this.fenlei = fenlei;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getPictureaddress() {
        return pictureaddress;
    }

    public void setPictureaddress(String pictureaddress) {
        this.pictureaddress = pictureaddress;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getShicai() {
        return shicai;
    }

    public void setShicai(String shicai) {
        this.shicai = shicai;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
