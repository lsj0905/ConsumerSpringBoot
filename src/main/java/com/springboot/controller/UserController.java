package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;


    @RequestMapping(value = "/user/{id}")
    public User getUsers(@PathVariable("id") String id){
        return userServiceImp.find(id);
    }
    @RequestMapping(value = "/user1/{id}" ,method = RequestMethod.GET)
    public User getById(@PathVariable("id") int id){

        return userServiceImp.getById(id);

    }
    @RequestMapping(value = "/insert/{name}" ,method = RequestMethod.PUT)
    public boolean insert(@PathVariable("name") String name){

        System.out.println(name);
        return userServiceImp.insert(name);
    }

    @RequestMapping(value = "/getUsers" ,method = RequestMethod.GET)
    public List<User> getUsers(){
        return userServiceImp.getUsers();
    }

    @RequestMapping(value = "/updateUser" , method = RequestMethod.POST)
    public boolean updateUser(User user){
        return userServiceImp.updateUser(user);
    }

    @RequestMapping(value = "/deletrUser/{id}" ,method = RequestMethod.DELETE)
    public boolean deleteUser(int id){

        return userServiceImp.deleteUser(id);
    }

    @RequestMapping(value = "/deleteAllUsers" , method = RequestMethod.DELETE)
    public boolean deleteAllUsers(){

        return  userServiceImp.deleteAllUsers();
    }



}
