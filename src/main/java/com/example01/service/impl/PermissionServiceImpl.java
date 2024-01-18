package com.example01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example01.entity.Permission;
import com.example01.mapper.PermissionMapper;
import com.example01.service.PermissionService;
import org.springframework.stereotype.Service;



/**
* @author 15700
* @description 针对表【t_permission】的数据库操作Service实现
* @createDate 2024-01-13 11:39:17
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService {

}




