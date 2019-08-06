package com.weiguang.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Room {
    private Integer roomid;

    private String roomname;

    private Integer peoplecount;

    private Integer videocount;

    private Integer ownerid;

    private Integer roomscale;

    private Integer roomaccess;

    private Integer roomstate;

    private Integer roomtype;

    private Date buildtime;

    private String resource;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date edittime;

    private String resourcetype;

    private String resourceimg;

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }

    public Integer getPeoplecount() {
        return peoplecount;
    }

    public void setPeoplecount(Integer peoplecount) {
        this.peoplecount = peoplecount;
    }

    public Integer getVideocount() {
        return videocount;
    }

    public void setVideocount(Integer videocount) {
        this.videocount = videocount;
    }

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    public Integer getRoomscale() {
        return roomscale;
    }

    public void setRoomscale(Integer roomscale) {
        this.roomscale = roomscale;
    }

    public Integer getRoomaccess() {
        return roomaccess;
    }

    public void setRoomaccess(Integer roomaccess) {
        this.roomaccess = roomaccess;
    }

    public Integer getRoomstate() {
        return roomstate;
    }

    public void setRoomstate(Integer roomstate) {
        this.roomstate = roomstate;
    }

    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Date edittime) {
        this.edittime = edittime;
    }

    public String getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype == null ? null : resourcetype.trim();
    }

    public String getResourceimg() {
        return resourceimg;
    }

    public void setResourceimg(String resourceimg) {
        this.resourceimg = resourceimg == null ? null : resourceimg.trim();
    }
}