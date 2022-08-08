package com.spring.boot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;


/**
 * service层
 *
 * @author 代码的路
 * @date 2022/8/8
 */

@Service
public class AsyncService {
    private final static Logger logger = LoggerFactory.getLogger(com.spring.boot.service.AsyncService.class);
    public static final int DoTime = 5000;

    @Async  // 表明该方法是异步方法。如果注解在类上，那表明类里面的所有方法都是异步
    public void executeAsyncTask(int i) throws Exception {
        logger.info("\t 完成任务" + i);
        System.out.println("线程" + Thread.currentThread().getName() + " 执行异步任务：" + i);
        Thread.sleep(10000);
    }


    // 通过Future<T>来接受异步方法的处理结果
    @Async
    public Future<Long> subByAsync() throws Exception {
        long start = System.currentTimeMillis();
        long sum = 0;
        Thread.sleep(DoTime);
        long end = System.currentTimeMillis();
        sum = end - start;
        logger.info("\t 完成任务一");
        return new AsyncResult<>(sum);
    }

    // 仅使用异步注解的方式实现异步方法
    @Async
    public void subByVoid() throws Exception {
        long start = System.currentTimeMillis();
        long sum = 0;
        Thread.sleep(DoTime);
        long end = System.currentTimeMillis();
        sum = end - start;
        logger.info("\t 完成任务二   ");
        logger.info("注解任务执行的时间是： " + sum + "（毫秒）");
    }

    // 使用同步计算的方式--同步调用
    public long subBySync() throws Exception {
        long start = System.currentTimeMillis();
        long sum = 0;
        Thread.sleep(DoTime);
        long end = System.currentTimeMillis();
        sum = end - start;
        logger.info("\t 完成任务三   ");
        return sum;
    }

}
