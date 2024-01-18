package com.example01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_role
 */
@TableName(value ="t_role")
@Data
public class Role implements Serializable {
    private Integer roleId;

    private String name;

    private String remark;

    private static final long serialVersionUID = 1L;
}