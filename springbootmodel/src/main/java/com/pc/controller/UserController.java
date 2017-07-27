package com.pc.controller;

import com.pc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by PC on 2017/7/24.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getuser")
    public Map<String,Object> home() {
        Map<String,Object> map=userService.findUserByid(11);
        return map;
    }
    @RequestMapping("/getRole")
    public Map<String,Object> getRole() {
        Map<String,Object> map=userService.findUserByid(11);
        return map;
    }
    @RequestMapping("/getInfo")
    public Map<String,Object> getInfo() {
        Map<String,Object> map=userService.findUserByid(11);
        return map;
    }
}
