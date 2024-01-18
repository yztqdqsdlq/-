package com.example01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_user_role
 */
@TableName(value ="t_user_role")
@Data
public class UserRole implements Serializable {
    private Integer userRoleId;

    private Integer roleId;

    private Integer userId;

    private static final long serialVersionUID = 1L;
}