package com.zdc.tcms.biz.entity;

import java.util.Date;

/**
 * 用户实体类
 */
public class User {

    private Long userid;

    private String username;

    private String password;

    private String phone;

    private Date createtime;

    private Integer status;

    private String pictureaddress;

    private String gender;

    private String tzlx;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPictureaddress() {
        return pictureaddress;
    }

    public void setPictureaddress(String pictureaddress) {
        this.pictureaddress = pictureaddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTzlx() {
        return tzlx;
    }

    public void setTzlx(String tzlx) {
        this.tzlx = tzlx;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", createtime=" + createtime +
                ", status=" + status +
                ", pictureaddress='" + pictureaddress + '\'' +
                ", gender='" + gender + '\'' +
                ", tzlx='" + tzlx + '\'' +
                '}';
    }
}
