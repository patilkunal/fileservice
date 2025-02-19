package com.example.fileservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
@EnableAsync
public class ApplicationConfig {

    @Value(("${fileimport.thread.count:4}"))
    private int maxThreads;

    @Bean
    public ExecutorService fixedThreadPool() {
        return Executors.newFixedThreadPool(maxThreads);
    }
//    @Bean
//    public TaskScheduler fixedTaskScheduler() {
//        ThreadPoolTaskScheduler t = new ThreadPoolTaskScheduler();
//        t.setPoolSize(maxThreads);
//        t.setThreadNamePrefix("ThreadPoolTaskScheduler");
//        return t;
//    }
}
