package com.example01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

@TableName("t_test")
@Data
public class Test {
    private Integer id;
    private String name;
}
