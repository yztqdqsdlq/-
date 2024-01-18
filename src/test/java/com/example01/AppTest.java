package com.example01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AppTest {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("/user/**");
        list.add("/product/**");
        list.add("/equipment/**");

        String uri = "/order/read?orderId=123456";

        AntPathMatcher matcher = new AntPathMatcher();

        System.out.println(matcher.match("/user/**", "/user/read?orderId=123456"));
    }
}
