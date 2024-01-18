package com.example01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName t_user_info
 */
@TableName(value ="t_user_info")
@Data
public class UserInfo implements Serializable {
    private Integer userId;

    private String username;

    private String password;

    private String gender;

    private String email;

    private String phoneNumber;

    private Date lastLoginTime;

    private String enable;

    private Date createDate;

    private Date updateDate;

    private static final long serialVersionUID = 1L;
}