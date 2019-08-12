package com.weiguang.controller;


import com.github.pagehelper.PageInfo;
import com.weiguang.pojo.Blog;
import com.weiguang.pojo.Reply;
import com.weiguang.pojo.Users;
import com.weiguang.service.ReplyService;
import com.weiguang.service.UsersService;
import com.weiguang.utils.DataView;
import com.weiguang.utils.StatusUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ReplyController {


    @Resource
    private ReplyService replyService;

    @Resource
    private UsersService usersService;


    //添加回復
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/addReply")
    public DataView addRply(Reply reply){
      int i= replyService.insert(reply);
      if (i>0){
          DataView<Blog> blogDatView = new DataView<>();
          blogDatView.setCode(0);
          blogDatView.setMsg("成功");
          return  blogDatView;
      }
      return  null;
    }

    //回復
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/getAllReply")
    public DataView getAllReply(@RequestParam(defaultValue = "1") int index,Integer blogid){
        DataView<Reply> replyDataView = new DataView<>();
        replyDataView.setCode(0);
        replyDataView.setMsg("成功");
    PageInfo<Reply> replyLists = replyService.getReplyList(index, StatusUtil.PAGESIZE, blogid);
    List<Reply> replyList= replyLists.getList();
        for (Reply reply : replyList) {
            Integer uid = reply.getUid();
            Users user = usersService.findbyid(uid);
            reply.setUsers(user);


        }
    replyDataView.setData(replyList);
    return  replyDataView;
}

    //回復
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/getreply")
    public DataView<Reply> getReply(Integer uid){
        List<Reply> replylist = replyService.getReplyByUid(uid);
        DataView<Reply> replyDataView = new DataView<>();
        replyDataView.setCode(0);
        replyDataView.setMsg("成功");
        replyDataView.setData(replylist);
        return  replyDataView;
    }
}
