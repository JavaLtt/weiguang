package com.weiguang.mapper;

import com.weiguang.pojo.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {

    //获取回复列表
    List<Reply> getReplyList(Integer blogid);

    List<Reply> getReplyByUid(@Param("uid")Integer uid);
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}