package com.pc.config.security;

import com.pc.dao.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by PC on 2017/8/5.
 * 自定义用户登录验证
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserService userService;

    /**
     * 自定义验证方式
     * 默认请求为：/j_spring_security_check
     * 自定义表单参数的name属性，默认是 j_username 和 j_password
     */
    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        MyUserDetails user = (MyUserDetails) userService.loadUserByUsername(username);
        if(user == null){
            throw new BadCredentialsException("Username not found.");
        }

        //加密过程在这里体现
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
