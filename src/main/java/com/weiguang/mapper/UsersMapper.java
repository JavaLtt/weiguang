package com.weiguang.mapper;

import com.weiguang.pojo.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    //根据手机号查询对象
    public Users fingbyphone(String phonenumber);

 //根据wid查询friend
    public Users findfriendbywid(int wid );
    //根据名称模糊差friend
    public List<Users> findfriendbyname( @Param("name") String name);
}
