package com.weiguang.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiguang.mapper.RoomMapper;
import com.weiguang.pojo.Room;
import com.weiguang.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomService {
    @Resource
    private RoomMapper roomMapper;

    @Override
    public PageInfo<Room> findallroom(int index, int size,Map map) {
        PageHelper.startPage(index,size);
        String resources=(String) map.get("resources");
        if(resources!=null){
            List<Room> rooms= JSONObject.parseArray(resources,Room.class);
            List<String> rlist=new ArrayList<>();
            for (Room room : rooms) {
                rlist.add(room.getResourcetype());
            }
            map.put("rlist",rlist);
        }
        List<Room> roomList = roomMapper.findall(map);
        PageInfo<Room> pageInfo=new PageInfo<>(roomList);
        return pageInfo;
    }
    
    
     @Override
    public PageInfo<Room> selectAll(int index,int size,Room room) {
        PageHelper.startPage(index,size);
        List<Room> roomList = roomMapper.selectAll(room);
        PageInfo<Room> pageInfo = new PageInfo<>(roomList);
        return pageInfo;
    }

    @Override
    public Room selectByOwnerid(int ownerid) {
        return roomMapper.selectByOwnerid(ownerid);
    }
    
    
     @Override
    public int insertSelective(Room record) {
        return roomMapper.insertSelective(record);
    }
    
    @Override
    public Room IntotheRoom(int ownerID) {
        return roomMapper.selectByPrimaryKey(ownerID);
    }

    @Override
    public PageInfo selectVideosInfo(int index,int size,String keyWord) {
        PageHelper.startPage(index,size);
        List videoList=roomMapper.selectVideosByName(keyWord);
        PageInfo pageInfo=new PageInfo(videoList);
        return pageInfo;
    }

    @Override
    public int selectVideoCount(String keyWord) {
        return roomMapper.selectVideoCount(keyWord);
    }

    @Override
    public PageInfo selectMusicInfo(int index,int size,String keyWord) {
        PageHelper.startPage(index,size);
        List musicList=roomMapper.selectMusicByName(keyWord);
        PageInfo pageInfo=new PageInfo(musicList);
        return pageInfo;
    }

    @Override
    public int selectMusicCount(String keyWord) {
        return roomMapper.selectMusicCount(keyWord);
    }

}
