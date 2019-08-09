package com.weiguang.mapper;

import com.weiguang.pojo.Room;

import java.util.List;
import java.util.Map;

public interface RoomMapper {
    int deleteByPrimaryKey(Integer roomid);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomid);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    public List<Room> findall(Map map);
}