package com.chapter13_quartz.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MySchedule {
    @Scheduled(fixedDelay = 1000)
    public void fixDelay(){
        System.out.println("fixDelay:"+new Date());
    }
    @Scheduled(fixedRate = 2000)
    public void fixedRate(){
        System.out.println("fixedRate:"+new Date());
    }
    @Scheduled(initialDelay = 1000,fixedRate = 2000)
    public void initialDelay(){
        System.out.println("initialDelay:"+new Date());
    }
    @Scheduled(cron = "0 * * * * ?")
    public void cron(){
        System.out.println("cron:"+new Date());
    }
}
