package com.weiguang.mapper;

import com.weiguang.pojo.Friend;

public interface FriendMapper {
    
    //查找好友
    List selectFriendByID(Integer id);

    //查找不看动态的好友
    List selectCoverByID(Integer id);
    
    //查询当前用户的全部比心好友的id
    List<Friend> selectByUid(int uid);
    
    int deleteByPrimaryKey(Integer id);

    int insert(Friend record);

    int insertSelective(Friend record);

    Friend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);
 //查找用户
    public Friend findfriend(Map map);
}
