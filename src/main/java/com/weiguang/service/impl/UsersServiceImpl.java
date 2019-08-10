package com.weiguang.service.impl;

import com.weiguang.mapper.UsersMapper;
import com.weiguang.pojo.Users;
import com.weiguang.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: liutong
 * @date: 2019-08-01 22:09
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public Users findbyid(int id) {

        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public Users fingbyphone(String phonenumber) {
        return usersMapper.fingbyphone(phonenumber);
    }

    @Override
    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }
    
      @Override
    public Users findbyid(int id) {

        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public Users findfriendbywid(int wid) {
        Users users = usersMapper.findfriendbywid(wid);
        return users;
    }

    @Override
    public List<Users> findfriendbyname(String name) {

        List<Users> usersList = usersMapper.findfriendbyname(name);

        return usersList;
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }
}


