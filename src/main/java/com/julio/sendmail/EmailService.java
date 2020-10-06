package com.julio.sendmail;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}