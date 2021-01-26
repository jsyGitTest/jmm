package com.example.jm.jmm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SpringCacheController {

    /**
     * @Description:
     *
     *
     * test::testCache
     *
    **/
    @Cacheable(value = "test", key = "#root.method.name")
    @GetMapping("/testCache")
    public String testCache(){
        log.info("============");
        return "成功";
    }
}
