package com.example01.controller;

import com.example01.entity.UserInfo;
import com.example01.service.UserInfoService;
import com.example01.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/readAll")
    public R<List<UserInfo>> readAllUser() {
        return R.ok(userInfoService.list());
    }

    @PostMapping("/create")
    public R<String> createUser(@RequestBody UserInfo userInfo) {
        return R.ok(userInfoService.save(userInfo) ? "ok" : "fail");
    }
}
