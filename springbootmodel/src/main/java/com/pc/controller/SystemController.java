package com.pc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by PC on 2017/7/23.
 */
@RestController
@RequestMapping("/sys")
public class SystemController {

    @RequestMapping("/index")
    public String home(HttpServletRequest request, HttpServletResponse response){
        return "welcome";
    }
    @RequestMapping("/index2")
    public String index(HttpServletRequest request, HttpServletResponse response){
        return "welcome index";
    }
}
