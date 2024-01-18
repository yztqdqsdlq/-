package com.example01.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example01.entity.Permission;
import com.example01.entity.UserInfo;

import java.util.List;

/**
* @author 15700
* @description 针对表【t_user_info】的数据库操作Service
* @createDate 2024-01-13 11:39:17
*/
public interface UserInfoService extends IService<UserInfo> {
    /**
     * 读取用户权限
     * @param username 用户
     * @return 权限集合
     */
    List<Permission> readPermissionByUsername(String username);
}
