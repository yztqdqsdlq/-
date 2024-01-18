package com.example01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_role_permission
 */
@TableName(value ="t_role_permission")
@Data
public class RolePermission implements Serializable {
    private Integer rolePermissionId;

    private Integer roleId;

    private Integer permissionId;

    private static final long serialVersionUID = 1L;
}