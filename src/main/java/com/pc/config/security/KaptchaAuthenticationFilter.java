package com.pc.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by PC on 2017/8/10.
 */
public class KaptchaAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private String servletPath; //提交地址
    public KaptchaAuthenticationFilter(String servletPath,String failureUrl) {
        super(servletPath);
        this.servletPath=servletPath;
        setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(failureUrl));

    }

    @Override

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse)response;
        //验证验证码是否正确
        if ("POST".equalsIgnoreCase(req.getMethod())&&servletPath.equals(req.getServletPath())){
            String expect = (String) req.getSession().getAttribute("userSessionCode");
//            if(expect!=null&&!expect.equalsIgnoreCase(req.getParameter("kaptcha"))){
//                unsuccessfulAuthentication(req, res, new InsufficientAuthenticationException("输入的验证码不正确"));
//                System.out.println("验证码输入错误");
//                return;
//            }
        }
        chain.doFilter(request,response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        return null;

    }
}
