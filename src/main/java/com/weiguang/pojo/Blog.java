package com.weiguang.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Blog {
    private Integer blogid;

    private String blogcontent;

    private String blogimage;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date blogtime;

    private Integer uid;

    private Integer replycount;

    private Integer likecount;

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public String getBlogcontent() {
        return blogcontent;
    }

    public void setBlogcontent(String blogcontent) {
        this.blogcontent = blogcontent == null ? null : blogcontent.trim();
    }

    public String getBlogimage() {
        return blogimage;
    }

    public void setBlogimage(String blogimage) {
        this.blogimage = blogimage == null ? null : blogimage.trim();
    }

    public Date getBlogtime() {
        return blogtime;
    }

    public void setBlogtime(Date blogtime) {
        this.blogtime = blogtime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }
}