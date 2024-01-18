package com.example01.authorization;

import cn.hutool.core.util.ObjUtil;
import com.example01.entity.*;
import com.example01.service.UserInfoService;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.List;

@Component
public class Authorization {
    @Resource
    private UserInfoService userInfoService;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    public Boolean verification(Claims claims, String url) {
        if (ObjUtil.isEmpty(claims)) {
            return false;
        }

        String username = claims.get("username").toString();

        List<Permission> permissionList = userInfoService.readPermissionByUsername(username);

        if (ObjUtil.isEmpty(permissionList)) {
            return false;
        }

        for (Permission permission : permissionList) {
            if (antPathMatcher.match(permission.getUrl(), url)) {
                return true;
            }
        }

        return false;
    }
}
