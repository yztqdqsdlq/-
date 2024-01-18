package com.example01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_permission
 */
@TableName(value ="t_permission")
@Data
public class Permission implements Serializable {
    private Integer permissionId;

    private String permissionName;

    private String url;

    private static final long serialVersionUID = 1L;
}