package com.pc.config.security;

import com.pc.dao.PermissionDao;
import com.pc.dao.UserDao;
import com.pc.model.Permission;
import com.pc.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2017/7/27.
 * 通过用户名，获取用户的权限和其它信息
 */
@Service
public class CustomUserService implements UserDetailsService {  //自定义UserDetailsService 接口
    @Autowired
    UserDao userDao;
    @Autowired
    PermissionDao permissionDao;

    public UserDetails loadUserByUsername(String username) {
        SysUser user = userDao.findByUserName(username);
        if (user != null) {
            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {
                    System.out.println("用户拥有的资源信息"+permission.getUrl());
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getUrl());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}