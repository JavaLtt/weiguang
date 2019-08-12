package com.weiguang.mapper;

import com.weiguang.pojo.Blog;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer blogid);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer blogid);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
    //动态查询
    public List<Blog> findbyUserId(int userId);
    
     //获取·博客动态列表
    public List<Blog> getBlogList();
}
