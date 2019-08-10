package com.weiguang.service;

import com.github.pagehelper.PageInfo;
import com.weiguang.pojo.Room;

import java.util.Map;

public interface RoomService{
    public PageInfo<Room> findallroom(int index, int size, Map map);
    
    //创建房间:搜索,条件查询房间
    PageInfo<Room> selectAll(int index, int size, Room room);
    //根据资源拥有着查询资源信息
    Room selectByOwnerid(int ownerid);
    
}
