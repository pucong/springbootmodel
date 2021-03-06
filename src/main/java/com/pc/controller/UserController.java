package com.pc.controller;

import com.pc.config.security.CustomUserService;
import com.pc.model.SysUser;
import com.pc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by PC on 2017/7/24.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserService customUserService;

    @RequestMapping("/loginValid")
    @ResponseBody
    public Object login(@AuthenticationPrincipal SysUser loginedUser, @RequestParam(name = "logout", required = false) String logout) {
        if (logout != null) {
            return "退出登录";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (loginedUser != null) {
            return customUserService.loadUserByUsername(loginedUser.getUsername());
        }
        return "登录成功";
    }

    @RequestMapping("/getuser")
    public Map<String,Object> home() {
        Map<String,Object> map=userService.findUserByid(1);
        return map;
    }
    @RequestMapping("/getRole")
    public Map<String,Object> getRole() {
        Map<String,Object> map=userService.findUserByid(1);
        return map;
    }
    @RequestMapping("/getInfo")
    public Map<String,Object> getInfo() {
        Map<String,Object> map=userService.findUserByid(1);
        return map;
    }
}
