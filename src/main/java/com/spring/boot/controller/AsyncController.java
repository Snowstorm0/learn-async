package com.spring.boot.controller;

import com.spring.boot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller层
 *
 * @author 代码的路
 * @date 2022/8/8
 */

@RestController
@RequestMapping("/homepage")
public class AsyncController {

    @Autowired
    AsyncService asyncTaskService;

    @GetMapping("/learnAsync")
    public String learnAsync(){
        for (int i = 0; i < 5; i++) {
            asyncTaskService.executeAsyncTask(i);
        }
        return "1";
    }
}
