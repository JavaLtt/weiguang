package com.weiguang.mapper;

import com.weiguang.pojo.Blacklist;

public interface BlacklistMapper {
    
    //查找本人黑名单用户
    List selectBlackByID(Integer id);
    
    int deleteByPrimaryKey(Integer id);

    int insert(Blacklist record);

    int insertSelective(Blacklist record);

    Blacklist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blacklist record);

    int updateByPrimaryKey(Blacklist record);
     //查找id
    public Blacklist findid(Map map);
}
