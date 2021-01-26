package com.example.jm.jmm.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

@EnableCaching
@Configuration
public class MyCacheConfig {

    /**
     * @Description: 自定义序列化格式
     * @Param: []
     * @Return: org.springframework.data.redis.cache.RedisCacheConfiguration
     * @Author: Jiangsy
     * @Date: 2021/1/26
    **/
    @Bean
    RedisCacheConfiguration redisCacheConfiguration(){
        return null;
    }
}
