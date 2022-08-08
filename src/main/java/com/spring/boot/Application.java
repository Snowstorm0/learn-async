package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动类
 *
 * @author 代码的路
 * @date 2022/8/8
 */

@SpringBootApplication
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}




//
//@SpringBootApplication
//@EnableAsync  // 开启Springboot对于异步任务的支持
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class Application {
//    @Autowired
//    private AsyncTaskService asyncTaskService;
//    private MyService myService;
//
//    @Test
//    public void contextLoads() {
//    }
//    @Test
//    public void threadTest() {
//        for (int i = 0; i < 20; i++) {
//            asyncTaskService.executeAsyncTask(i);
//        }
//    }
//}



