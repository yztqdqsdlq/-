package com.example01.filter;


import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.example01.authorization.Authorization;
import com.example01.utils.RedisUtils;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

@jakarta.servlet.annotation.WebFilter(value = "/*")
public class WebFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Filter.class);
    @Resource
    private Authorization authorization;
    @Resource
    private RedisUtils redisUtils;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("utf-8");

        String jwt = request.getHeader("jwt");
        if (!request.getRequestURI().contains("/login")) {
           try {
               if (StrUtil.isEmpty(jwt)) {
                   response.getWriter().write("没有登录请先登录");
                   return;
               }

               Claims claims = Jwts.parser().verifyWith(redisUtils.getSecret()).build().parseSignedClaims(jwt).getPayload();

               if (!claims.getSubject().equals("dq")) {
                   response.getWriter().write("用户名不正确");
                   return;
               }
               if (!new Date().before(claims.getExpiration())) {
                   response.getWriter().write("jwt过期");
                   return;
               }
               if (!authorization.verification(claims, request.getRequestURI())) {
                   response.getWriter().write("权限不足");
                   return;
               }
           } catch (SignatureException e) {
               response.getWriter().write("jwt不正确");
               return;
           }
        }
        filterChain.doFilter(request, response);
    }

}
