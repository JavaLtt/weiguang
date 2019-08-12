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
    
    
    int insertSelective(Room record);
    
    //进入房间
    Room IntotheRoom(int ownerID);

    //关键字查找视频
    PageInfo selectVideosInfo(int index, int size, String keyWord);

    //关键字查找视频数量
    int selectVideoCount(String keyWord);

    //关键字查找音乐
    PageInfo selectMusicInfo(int index,int size,String keyWord);

    //关键字查找音乐数量
    int selectMusicCount(String keyWord);
    
        //隨緣匹配
    Room getRoomList(Map map);
    
}
