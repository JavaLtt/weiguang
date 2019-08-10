package com.weiguang.controller;

import com.github.pagehelper.PageInfo;
import com.weiguang.mapper.UsersMapper;
import com.weiguang.pojo.Room;
import com.weiguang.pojo.Users;
import com.weiguang.service.RoomService;
import com.weiguang.service.UsersService;
import com.weiguang.utils.DataView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liutong
 * @date: 2019-08-06 11:00
 */
@RestController
public class RoomController {

    @Resource
    private RoomService roomService;
    @Resource
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.POST,value = "/getAll")
    //String roomname,int roomtype,int resourcetype
    public DataView<Room> getAll(@RequestParam(defaultValue = "1") int index, Room room){
        PageInfo<Room> pageInfo = roomService.selectAll(index,1,room);
        DataView<Room> roomDataView = new DataView<>();
        roomDataView.setCode(0);
        roomDataView.setMsg("成功");
        roomDataView.setData(pageInfo.getList());
        return roomDataView;
    }


    @RequestMapping(method = RequestMethod.POST,value = "/createRoom")
    public Map createRoom(int userid,int roomtype,int roomscale,int roomaccess,int ownerid){
        Users users = usersService.findbyid(userid);
        Room room = roomService.selectByOwnerid(ownerid);
        Room newroom = new Room();
        newroom.setRoomname(room.getRoomname());
        newroom.setOwnerid(userid);
        newroom.setResource(room.getResource());
        newroom.setRoomaccess(roomaccess);
        newroom.setRoomscale(roomscale);
        newroom.setRoomtype(roomtype);
        newroom.setBuildtime(new Date());
        newroom.setResourceimg(room.getResourceimg());
        newroom.setResourcetype(room.getResourcetype());
        newroom.setRoomstate(0);
        Map map = new HashMap();
        int i = roomService.insertSelective(newroom);
        if (i>0){
            map.put("code",0);
            map.put("msg","成功");
            Map map1 = new HashMap();
            map1.put("users",users);
            map1.put("roomname",newroom.getRoomname());
            map1.put("resource",newroom.getResource());
            map1.put("roomscale",roomaccess);
            map1.put("roomaccess",roomscale);
            map.put("data",map1);
           return map;
        }else {
            map.put("code",0);
            map.put("msg","失败");
            map.put("data","");
            return map;
        }
    }


}
