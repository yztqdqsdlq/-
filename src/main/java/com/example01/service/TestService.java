package com.example01.service;

import com.example01.entity.Test;

import java.util.List;

public interface TestService {
    void createBatch();

    List<Test> readAll();
}
