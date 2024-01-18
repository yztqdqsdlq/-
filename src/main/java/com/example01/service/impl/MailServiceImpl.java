package com.example01.service.impl;

import com.example01.service.MailService;
import jakarta.annotation.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Resource
    private JavaMailSender javaMailSender;
    @Override
    public void send(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(to);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }
}
