package com.weiguang.controller;

import com.github.pagehelper.PageInfo;
import com.weiguang.pojo.Room;
import com.weiguang.pojo.Users;
import com.weiguang.service.RoomService;
import com.weiguang.service.SmsService;
import com.weiguang.service.UsersService;
import com.weiguang.utils.DataView;
import com.weiguang.utils.StatusUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class UsersController {
    @Resource
    private UsersService usersService;
    @Resource
    private SmsService smsService;
    @Resource
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.POST,value ="getaccess")
    public Map getyanpass(String phonenumber, HttpSession session) {
        Map map = new HashMap();
        int access = smsService.single_sendTest(phonenumber);
        session.setAttribute("access", access);
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", null);
        System.out.println(access);
        return map;
    }

    /*
     * 测试验证码
     * */
    @RequestMapping(method = RequestMethod.POST, value = "/a")
    public String a(String access, HttpSession session) {
        session.setAttribute("access", access);
        System.out.println("++++++++++++a"+session.getAttribute("access"));
        return "ok";
    }

    /*
     * 登录
     * */
    @RequestMapping(method = RequestMethod.POST, value = "longin")
    public Map login(String phonenumber, String access, HttpSession session) {
        Map map = new HashMap();
        String access1 = (String) session.getAttribute("access");
        System.out.println("++++++++++++"+access1);
        Users users = usersService.fingbyphone(phonenumber);
        System.out.println("++++++++++"+users.getName());
        if (users == null) {
            map.put("code", 1);
            map.put("msg", "手机号未注册");
            map.put("data", null);
        } else {
            if (access1.equals(access)) {
                Map getallroom = this.getallroom(1, -1, -1, -1, -1, -1, null);
                return getallroom;
            } else {
                map.put("code", 1);
                map.put("msg", "验证码错误");
                map.put("data", null);
            }
        }
        return map;
    }

    /*
     * 注册
     * */
    @RequestMapping(method = RequestMethod.POST, value = "registry")
    public Map newregistry(Users users,String access,HttpSession session) {
        Map map = new HashMap();
        String usersPhonenumber = users.getPhonenumber();
        Users fingbyphone = usersService.fingbyphone(usersPhonenumber);
        if (fingbyphone!=null){
            map.put("code",1);
            map.put("msg","该手机号已被注册");
            map.put("data",null);
            return map;
        }
        String access1 = (String) session.getAttribute("access");
        if(access.equals(access1)){
            int i = usersService.insertSelective(users);
            Map getallroom = this.getallroom(1, -1, -1, -1, -1, -1, null);
            return getallroom;
        }else{
            map.put("code", 1);
            map.put("msg", "验证码错误");
            map.put("data", null);
        }
        return map;
    }

    /*
     * 查询个人信息
     * */
    @RequestMapping(method = RequestMethod.POST, value = "selectUsers")
    public Map findbyid(int userid) {

        Users users = usersService.findbyid(userid);
        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", users);
        return map;
    }

    /*
    * 查询全部房间
    * */

    @RequestMapping(method = RequestMethod.POST, value = "getAllRoom")
    public Map getallroom(@RequestParam(defaultValue = "1") int index,
                          @RequestParam(defaultValue = "-1")int roomtype,
                          @RequestParam(defaultValue = "-1")int gender,
                          @RequestParam(defaultValue = "-1")int beginage,
                          @RequestParam(defaultValue = "-1")int endage,
                          @RequestParam(defaultValue = "-1")int roomscale,
                          String resources){
        Map map1 = new HashMap();
        map1.put("roomtype",roomtype);
        map1.put("gender", gender);
        map1.put("beginage", beginage);
        map1.put("endage",endage);
        map1.put("resources", resources);
        map1.put("roomscale",roomscale);
        PageInfo<Room> pageInfo = roomService.findallroom(index, StatusUtil.PAGESIZE, map1);

        Map map2 = new HashMap();

        int num = (int) (Math.random() * (300 - 50 + 1) + 50);
        map2.put("peoplecount", num);
        map2.put("room", pageInfo.getList());

        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", map2);
        return map;
    }
    
    /*
    * 退出登录
    *
    * */
    @RequestMapping(method = RequestMethod.POST,value = "loginout")
    public Map loginout(int userid, HttpSession session){
        session.invalidate();
        HashMap map = new HashMap<>();
        map.put("code",0);
        map.put("msg","成功");
        return map;
    }
    
    
    /*
* 根据微光号或名称模糊查询用户
*
* */
    @RequestMapping(method = RequestMethod.POST,value = "selectFrinds")
    public Map findfriends(String infomation){
        boolean isNum = infomation.matches("[0-9]+");
        HashMap map = new HashMap();
        if(isNum){
            int info = Integer.parseInt(infomation);
            Users users = usersService.findfriendbywid(info);
            map.put("code",0);
            map.put("msg","成功");
            map.put("data",users);
            return map;
        }
        List<Users> usersList = usersService.findfriendbyname(infomation);
        map.put("code",0);
        map.put("msg","成功");
        map.put("data",usersList);
        return  map;
    }


}
