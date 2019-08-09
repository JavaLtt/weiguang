package com.weiguang.service;

import com.github.pagehelper.PageInfo;
import com.weiguang.pojo.Room;

import java.util.Map;

public interface RoomService{
    public PageInfo<Room> findallroom(int index, int size, Map map);
}
