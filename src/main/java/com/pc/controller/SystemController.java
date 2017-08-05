package com.pc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PC on 2017/7/23.
 */
@RestController
public class SystemController {

    @RequestMapping("/")
    public String index(Model model){
        return "欢迎来到HOME页面,您拥有 ROLE_HOME 权限";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }
}
