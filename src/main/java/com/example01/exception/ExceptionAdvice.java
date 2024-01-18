package com.example01.exception;

import com.example01.utils.R;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常通知
 */
@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<String> exceptionResponse(MalformedJwtException e) {
        return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(R.fail("发生错误：" + e.getMessage()).toString());
    }
}
