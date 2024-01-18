package com.example01.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example01.entity.Person;

import java.util.List;

public interface PersonService extends IService<Person> {
    Person findByUsername(String username);
}
