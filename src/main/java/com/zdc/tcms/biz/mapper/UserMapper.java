package com.zdc.tcms.biz.mapper;

import com.zdc.tcms.biz.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    //@Select("select * from user where userid=#{userid}")
    User getUserById(Long userid);

    @Delete("delete from user where userid=#{userid}")
    int deleteUserById(Long userid);

    //@Insert("insert into user(userid,username,password,phone) values(#{userid}，#{username}，#{password}，#{phone})")
    int insertUser(User user);

    @Update("update user set username=#{username} where userid=#{userid}")
    int updateUser(User user);

    //@Select("select * from user where username=#{username} and password=#{password}")
    User getUserByLogin(@Param("username") String username, @Param("password") String password);

    User checkAccountExit(@Param("username") String username);

    User phoneCheckExit(@Param("phone") String phone);

    int updatePictureUrl(@Param("pictureaddress") String pictureaddress, @Param("username") String username);
}
