package com.example01.utils;

import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void setString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    public SecretKey getSecret() {
        String secret = (String) redisTemplate.opsForValue().get("secret");
        assert secret != null;
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public void setInteger(String key, Integer value) {
        redisTemplate.opsForValue().set(key, value, 120, TimeUnit.SECONDS);
    }

    public Integer getInteger(String key) {
        return (Integer) redisTemplate.opsForValue().get(key);
    }
}
