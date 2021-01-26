package com.example.jm.jmm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
    @Cacheable(value = "test", key = "#id")
    @GetMapping("/testCache")
    public HashMap testCache(String id){
        log.info("============");
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name","张三");
        return stringStringHashMap;
    }


    @CacheEvict(value = "test", key = "#id")
    @GetMapping("/delData")
    public HashMap delData(String id){
        log.info("============");
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name","张三");
        return stringStringHashMap;
    }




}
