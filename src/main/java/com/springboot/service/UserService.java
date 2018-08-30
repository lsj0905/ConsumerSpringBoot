package com.springboot.service;


import com.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {


     public User find(String id);

     public User getById(int id);

     public boolean insert(String name);

     public List<User> getUsers();

     public boolean updateUser(User user);

     public boolean deleteUser(int id);

     public boolean deleteAllUsers();

}
