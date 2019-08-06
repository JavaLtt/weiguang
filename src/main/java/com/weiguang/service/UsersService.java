package com.weiguang.service;

import com.weiguang.pojo.Users;

/**
 * @author: liutong
 * @date: 2019-08-01 22:09
 */
public interface UsersService {

    //根据主键id查询用户
    public Users findbyid(int id);
}
