package com.spring.boot.controller;

import com.spring.boot.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

/**
 * Controller层
 *
 * @author 代码的路
 * @date 2022/8/8
 */

@RestController
@RequestMapping("/homepage")
public class AsyncController {

    private final static Logger logger = LoggerFactory.getLogger(com.spring.boot.controller.AsyncController.class);


    @Autowired
    AsyncService asyncTaskService;

    /**
     * 自定义实现线程异步
     */
    @GetMapping("/learnAsync")
    public String learnAsync(){
        for (int i = 0; i < 10; i++) {
            try {
                asyncTaskService.executeAsyncTask(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "1";
    }

    @GetMapping("/learnFuture")
    @SuppressWarnings("static-access")
    public String index() {
        long start = System.currentTimeMillis();
        try {
            logger.info("--------------------------------------------\n");
            logger.info("每个任务执行的时间是：" + asyncTaskService.DoTime + "（毫秒）");

            Future<Long> task = asyncTaskService.subByAsync();
            asyncTaskService.subByVoid();
            long sync = asyncTaskService.subBySync();

            while (true) {
                if (task.isDone()) {
                    long async = task.get();
                    logger.info("异步任务执行的时间是：" + async + "（毫秒）");
                    logger.info("注解任务执行的时间是： -- （毫秒）");
                    logger.info("同步任务执行的时间是：" + sync + "（毫秒）");
                    break;
                }
            }
            logger.info("--------------------------------------------\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("\t........请求响应时间为：" + (end - start) + "（毫秒）");
        return "2";
    }
}
