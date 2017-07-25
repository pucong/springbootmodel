package com.pc.controller;

import com.pc.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by PC on 2017/7/24.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/home")
    public String home() {
        return "home";

    }


    @PreAuthorize("hasRole('user')")
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String toAdmin(){

        return "helloAdmin";
    }

    @RequestMapping("/hello")
    public String hello() {

        return "hello";

    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/")
    public String root() {
        return "index";

    }

    @RequestMapping("/403")
    public String error(){
        return "403";
    }
}
