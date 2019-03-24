package com.zdc.tcms.biz.mapper;

import com.zdc.tcms.biz.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    //@Select("select * from user where userid=#{userid}")
    public User getUserById(Long userid);

    @Delete("delete from user where userid=#{userid}")
    public int deleteUserById(Long userid);

    @Insert("insert into user(userid,username,password,phone) values(#{userid}，#{username}，#{password}，#{phone})")
    public int insertUser(User user);

    @Update("update user set username=#{username} where userid=#{userid}")
    public int updateUser(User user);

    //@Select("select * from user where username=#{username} and password=#{password}")
    public User getUserByLogin(@Param("username") String username, @Param("password") String password);
}
