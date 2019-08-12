package com.weiguang.mapper;

import com.weiguang.pojo.Room;

import java.util.List;
import java.util.Map;

public interface RoomMapper {
    
    //通过关键字搜索视频
    List selectVideosByName(String keyWord);

    //关键字搜索视频数量
    int selectVideoCount(String keyWord);

    //通过关键字搜索音乐
    List selectMusicByName(String keyWord);

    //关键字搜索音乐数量
    int selectMusicCount(String keyWord);
    
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
