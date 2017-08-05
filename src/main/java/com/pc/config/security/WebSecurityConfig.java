package com.pc.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created by PC on 2017/7/27.
 * 全局security配置
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;  //自定义登录验证
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;    //自定义请求拦截器

    @Autowired
    private CustomUserService customUserService;//自定义用户服务

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //将登录成功后的用户服务放给自定义的类处理
        auth.userDetailsService(customUserService);
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //将登录验证过程交给自定义验证工具
        auth.authenticationProvider(myAuthenticationProvider);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                    .loginPage("/login.html")    //登录页面
                    .failureUrl("/index.html") //登录失败页面
                    .usernameParameter("user-name") //表单提交name的参数设置
                    .passwordParameter("pwd")   //表单提交password参数设置
                    .loginProcessingUrl("/loginValid")  //登录的请求设置
                    .permitAll() //登录页面用户任意访问
                .and()
                .logout()
                    .logoutSuccessUrl("/login?logout")  //退出的请求
                    .permitAll(); //注销行为任意访问
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }
}
