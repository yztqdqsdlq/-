package com.example01.service.impl;

import com.example01.entity.Test;
import com.example01.mapper.TestMapper;
import com.example01.service.TestService;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * &#064;Description:  TestServiceImpl
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;

    @Override
    public void createBatch() {
        for (int i = 1; i < 10000; i++) {
            Test test = new Test();
            test.setId(i);
            test.setName("test" + i);
            testMapper.insert(test);
        }
    }

    @Override
    public List<Test> readAll() {
        return testMapper.selectList(null);
    }
}
