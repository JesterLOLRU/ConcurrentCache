package com.example.concurrentcache.config;

import com.example.concurrentcache.util.ConcurrentCache;
import com.example.concurrentcache.util.ConcurrentCacheImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class CacheConfiguration {

    @Bean("cache")
    public ConcurrentCache<String, String> concurrentCache() {
        return new ConcurrentCacheImpl<>(new HashMap<>());
    }
}
