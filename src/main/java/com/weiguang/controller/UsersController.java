package com.weiguang.controller;

import com.weiguang.pojo.Users;
import com.weiguang.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class UsersController {
    @Resource
    private UsersService usersService;

    /*
    * 查询个人信息
    * */
    @RequestMapping(method = RequestMethod.POST,value = "selectUsers")
    public Map findbyid(int userID){

        Users users = usersService.findbyid(userID);
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","成功");
        map.put("data",users);
        return map;
    }

}
