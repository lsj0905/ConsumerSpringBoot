package com.springboot.service.Imp;

import com.springboot.dao.UserMapper;
import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User find(String id) {
        return userMapper.find(id);
    }

    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    @Override
    public boolean insert(String name) {
        return userMapper.insert(name);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public boolean deleteAllUsers() {
        return userMapper.deleteAllUsers();
    }


}
