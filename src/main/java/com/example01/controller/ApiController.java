package com.example01.controller;

import cn.hutool.core.util.StrUtil;
import com.example01.entity.UserInfo;
import com.example01.service.MailService;
import com.example01.service.UserInfoService;
import com.example01.utils.R;
import com.example01.utils.RedisUtils;
import io.jsonwebtoken.*;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@RestController
public class ApiController {
    public final static Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    @Resource
    private RedisUtils redisUtils;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private MailService mailService;

    /**
     * 过期时间(单位:秒)
     */
    private static final long ACCESS_EXPIRE = 60 * 60 * 60 * 24 * 7;

    @GetMapping("/login")
    public String login(String username) {
        Date expireDate = Date.from(Instant.now().plusSeconds(ACCESS_EXPIRE));
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        return Jwts.builder()
                .header().add("alg", "HS512")
                .add("typ", "JWT")
                .and()
                .subject("dq")
                .id("dq_lq")
                .expiration(expireDate)
                .issuedAt(new Date())
                .claims(claims)
                .issuer("lq")
                .signWith(redisUtils.getSecret(), Jwts.SIG.HS512)
                .compact();
    }

//    @GetMapping("sendCode")
//    public Integer sendCode(String email) {
//        Integer code = new Random().nextInt(8999) + 1000;
//        redisUtils.setInteger("code", code);
//        mailService.send(email, "邮箱注册", "你好,你的验证码为" + code + ",请妥善保管.");
//        return code;
//    }

    @GetMapping("sendCode")
    public R<CompletableFuture<Integer>> sendCode(String email) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        Integer code = new Random().nextInt(8999) + 1000;

        // 将生成的验证码存储到 Redis 并设置过期时间
        redisUtils.setInteger("code", code);

        // 发送邮件的操作交给异步去做
        CompletableFuture<Void> sendMailFuture = CompletableFuture.runAsync(() -> {
            mailService.send(email, "邮箱注册", "你好,你的验证码为" + code + ",请妥善保管.");
        });

        // 等待发送邮件的异步操作完成，并将结果返回给用户
        sendMailFuture.thenAcceptBoth(future, (result, codeFuture) -> {
            future.complete(codeFuture);
        });

        return R.ok(future);
    }

    @GetMapping("/register")
    public R<String> register(String email, String password, Integer code) {
        if (StrUtil.isEmpty(email) || StrUtil.isEmpty(password)) {
            return R.fail("邮箱和密码不能为空!");
        }
        if (!Objects.equals(redisUtils.getInteger("code"), code)) {
            return R.fail("验证码错误!");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(email);
        userInfo.setEmail(email);
        userInfo.setPassword(password);
        userInfo.setCreateDate(new Date());
        userInfoService.save(userInfo);
        return R.ok("注册成功!");
    }

    @GetMapping("/test1")
    public String test1(String jwt) {
        Claims claims = Jwts.parser().verifyWith(redisUtils.getSecret()).build().parseSignedClaims(jwt).getPayload();
        if (!claims.getSubject().equals("dq")) {
            return "用户名不正确";
        }
        if (!new Date().before(claims.getExpiration())) {
            return "jwt过期";
        }
        return "ok";
    }

    @GetMapping("/hello")
    public String hello() {
        LOGGER.info("测试初始一些日志吧！");
        return "HelloWorld!";
    }

    @GetMapping("/set")
    public String set(String key, String value) {
        redisUtils.setString(key, value);
        return "ok";
    }

    @GetMapping("/get")
    public String get(String key) {
        return redisUtils.getString(key);
    }
}
