package com.quartz.code;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Collection;

@Configuration
public class QuartzConfig {
    @Bean
    MethodInvokingJobDetailFactoryBean jobDetailFactoryBean1(){
        //这是第一种JobDetail的配置方式，只需要指定Job的实例名以及调用方法即可
        //但是无法在创建JobDetail时传递参数
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("myFirstJob");
        bean.setTargetMethod("sayHello");
        return bean;
    }
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean2(){
        //通过JobDetailFactoryBean实现的需要指定JobClass可通过Map导入参数
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(MySecondJob.class);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("name","sang");
        bean.setJobDataMap(jobDataMap);
        bean.setDurability(true);
        return bean;
    }
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        //使用SimpleTriggerFactoryBean创建
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        //首先设置JobDetail
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean1().getObject());
        //其次配置任务次数
        simpleTriggerFactoryBean.setRepeatCount(3);
        //然后配置任务启动延时时间
        simpleTriggerFactoryBean.setStartDelay(1000);
        //最后配置任务的时间间隔
        simpleTriggerFactoryBean.setRepeatInterval(2000);
        return simpleTriggerFactoryBean;
    }
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        //在CronTriggerFactoryBean中主要配置JobDetail和CronExpression
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetailFactoryBean2().getObject());
        bean.setCronExpression("* * * * * ?");
        return bean;
    }
    @Bean
    SchedulerFactoryBean schedulerFactory(){
        //通过SchedulerFactoryBean创建SchedulerFactory
        SchedulerFactoryBean bean = new SchedulerFactoryBean();

        SimpleTrigger simpleTrigger = simpleTriggerFactoryBean().getObject();
        CronTrigger cronTrigger = cronTriggerFactoryBean().getObject();
        //setTriggers中参数为Trigger的class
        bean.setTriggers(simpleTrigger,cronTrigger);
        return bean;
    }
}
