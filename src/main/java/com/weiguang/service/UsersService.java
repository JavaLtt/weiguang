package com.weiguang.service;

import com.weiguang.pojo.Users;

/**
 * @author: liutong
 * @date: 2019-08-01 22:09
 */
public interface UsersService {

    //根据主键id查询用户
    public Users findbyid(int id);

    //根据手机号查询用户
    public Users fingbyphone(String phonenumber);

    //新增用户 注册
    int insertSelective(Users record);
    
    
      //根据主键id查询用户
    public Users findbyid(int id);
    //根据wid查询friend
    public Users findfriendbywid(int wid );
    //根据名称模糊差friend
    public List<Users> findfriendbyname(String name);
    //修改朋友数量
    int updateByPrimaryKey(Users record);

}
