package com.example01.controller;

import com.example01.entity.Test;
import com.example01.service.TestService;
import com.example01.service.impl.TestServiceImpl;
import com.example01.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Resource
    private TestService testService;
    @GetMapping("/createBatch")
    public String createBatch() {
        testService.createBatch();
        return "ok";
    }

    @GetMapping("/readAll")
    public R<List<Test>> readAll() {
        return R.ok(testService.readAll());
    }
}
