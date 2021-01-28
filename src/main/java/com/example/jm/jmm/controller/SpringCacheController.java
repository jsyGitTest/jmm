package com.example.jm.jmm.controller;

import com.example.jm.jmm.entity.MqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
    @Cacheable(value="voucher",key="#prodId+'-'+#bizId+'-'+#accAttr")
    @GetMapping("/testCache")
    public HashMap testCache(String prodId,String bizId,String accAttr){
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


    @CacheEvict(value = "getUnno", key = "#map.get('unno')")
    @GetMapping("/testmap")
    public HashMap testmap(@RequestBody Map<String,Object> map){
        log.info("============");
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name","张三");
        return stringStringHashMap;
    }




}
