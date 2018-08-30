package com.springboot.dao;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

     @Select("select id,username,password from user where id=#{id}")
     User find(@Param("id") String id);

     public User getById(int id);
     public boolean insert(String name);
     public List<User> getUsers();
     public boolean updateUser(User user);
     public boolean deleteUser(int id);
     public boolean deleteAllUsers();



}
