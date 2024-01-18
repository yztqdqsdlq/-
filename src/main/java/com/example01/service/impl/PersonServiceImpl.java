package com.example01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example01.entity.Person;
import com.example01.mapper.PersonMapper;
import com.example01.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {
    @Override
    public Person findByUsername(String username) {
        Person person = baseMapper.selectOne( new QueryWrapper<Person>().eq("name", username));
        return person;
    }
}
