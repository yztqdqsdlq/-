package com.example01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example01.entity.Role;
import com.example01.mapper.RoleMapper;
import com.example01.service.RoleService;
import org.springframework.stereotype.Service;

/**
* @author 15700
* @description 针对表【t_role】的数据库操作Service实现
* @createDate 2024-01-13 11:39:17
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {

}




