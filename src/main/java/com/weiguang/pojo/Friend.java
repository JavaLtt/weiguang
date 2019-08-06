package com.weiguang.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Friend {
    private Integer id;

    private Integer friendid;

    private Integer uid;

    private Integer state;

    private Integer showblog;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFriendid() {
        return friendid;
    }

    public void setFriendid(Integer friendid) {
        this.friendid = friendid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getShowblog() {
        return showblog;
    }

    public void setShowblog(Integer showblog) {
        this.showblog = showblog;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}