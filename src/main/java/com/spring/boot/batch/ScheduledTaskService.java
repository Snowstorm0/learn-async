package com.spring.boot.batch;

import com.spring.boot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@EnableScheduling
public class ScheduledTaskService {

    @Autowired
    AsyncService asyncService;

    @Scheduled(cron = "1/1 * * * * ? ")  //1s一次
    public void learnCron(){
        asyncService.learnScheduledAsync();
    }
}
