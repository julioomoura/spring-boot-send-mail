package com.julio.sendmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {
    @Autowired
    private EmailService emailService;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(cron = "0 * * * * *")
    public void reportCurrentTime() {
        log.info("Sending mail");
        String message = ("The time now is: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        emailService.sendSimpleMessage("juliomourajom@gmail.com", "Sending mail every minute", message);
    }
}
