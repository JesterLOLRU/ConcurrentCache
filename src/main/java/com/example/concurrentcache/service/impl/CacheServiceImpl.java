package com.example.concurrentcache.service.impl;


import com.example.concurrentcache.service.CacheService;
import com.example.concurrentcache.util.ConcurrentCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private ConcurrentCache<String, String> cache;

    @Override
    @Async
    public void putData(String key, String value) {
        cache.put(key, value);
    }

    @Override
    @Async
    public String getData(String key) {
        return cache.get(key);
    }
}
