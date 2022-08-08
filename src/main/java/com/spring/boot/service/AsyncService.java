package com.spring.boot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * service层
 *
 * @author 代码的路
 * @date 2022/8/8
 */

@Service
public class AsyncService {
    private final static Logger logger = LoggerFactory.getLogger(com.spring.boot.service.AsyncService.class);

    @Async  // 表明该方法是异步方法。如果注解在类上，那表明类里面的所有方法都是异步
    public void executeAsyncTask(int i) {
        logger.info("\t 完成任务" + i);
        System.out.println("线程" + Thread.currentThread().getName() + " 执行异步任务：" + i);
    }
}
