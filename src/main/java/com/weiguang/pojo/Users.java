package com.weiguang.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Users {
    private Integer userid;

    private String name;

    private String phonenumber;

    private Integer access;

    private Integer gender;

    private String icon;

    private Integer friendcount;

    private String info;

    private Integer weid;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String star;

    private String image;

    private Integer status;

    private Integer age;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getFriendcount() {
        return friendcount;
    }

    public void setFriendcount(Integer friendcount) {
        this.friendcount = friendcount;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getWeid() {
        return weid;
    }

    public void setWeid(Integer weid) {
        this.weid = weid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star == null ? null : star.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}