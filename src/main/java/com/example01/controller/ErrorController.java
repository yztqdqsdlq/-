package com.example01.controller;

import com.example01.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ErrorController extends BasicErrorController {
    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes, new ErrorProperties());
    }

    @Override
    @RequestMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> resultMap = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.APPLICATION_JSON));
        resultMap.put("code", 500);
        resultMap.put("message", resultMap.get("message"));
        return ResponseEntity.status(500)
                .contentType(MediaType.APPLICATION_JSON)
                .body(resultMap);
    }
}
