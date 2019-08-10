package com.weiguang.mapper;

import com.weiguang.pojo.Room;

import java.util.List;
import java.util.Map;

public interface RoomMapper {
    
     //创建房间,搜索,条件查询
    List<Room> selectAll(Room room);
    //根据资源拥有着查询资源信息
    Room selectByOwnerid(int ownerid);
    
    int deleteByPrimaryKey(Integer roomid);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomid);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    public List<Room> findall(Map map);
}
