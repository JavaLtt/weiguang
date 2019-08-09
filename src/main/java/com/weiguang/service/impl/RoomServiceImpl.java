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
}
