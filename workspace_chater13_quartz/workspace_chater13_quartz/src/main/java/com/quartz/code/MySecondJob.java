package com.quartz.code;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class MySecondJob extends QuartzJobBean {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    //继承了QuartzJobBean的bean需要实现executeInternal方法
    //该方法在被调用时使用
    @Override
    protected void executeInternal(JobExecutionContext context){
        System.out.println("Hello:"+name+":"+new Date());
    }
}
