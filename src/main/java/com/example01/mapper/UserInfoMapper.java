package com.example01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example01.entity.Permission;
import com.example01.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 15700
* @description 针对表【t_user_info】的数据库操作Mapper
* @createDate 2024-01-13 11:39:17
* @Entity pojo.com.example01.pojo.UserInfo
*/
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    /**
     * 读取用户权限
     * @param username 用户
     * @return 权限集合
     */
    List<Permission> readPermissionByUsername(@Param("username") String username);

    long test(@Param("list") String[] list);
}




