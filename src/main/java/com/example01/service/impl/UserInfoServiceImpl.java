package com.example01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example01.entity.Permission;
import com.example01.entity.UserInfo;
import com.example01.mapper.UserInfoMapper;
import com.example01.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 15700
* @description 针对表【t_user_info】的数据库操作Service实现
* @createDate 2024-01-13 11:39:17
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

    @Override
    public List<Permission> readPermissionByUsername(String username) {
        return baseMapper.readPermissionByUsername(username);
    }
}




