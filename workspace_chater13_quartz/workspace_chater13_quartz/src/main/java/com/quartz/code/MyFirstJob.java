package com.quartz.code;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyFirstJob {
    //普通的bean需要添加Component使用容器注入
    public void sayHello(){
        System.out.println("MyFirstJob:sayHello:"+new Date());
    }
}
