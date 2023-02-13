package com.example.concurrentcache.service.impl;


import com.example.concurrentcache.service.CacheService;
import com.example.concurrentcache.util.ConcurrentCache;
import com.example.concurrentcache.util.ConcurrentCacheImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CacheServiceImpl implements CacheService {

    private static ConcurrentCache<String, String> cache = createMap();

    @Override
    public void putData(String key, String value) {
        cache.putDataToCache(key, value);
    }

    @Override
    public String getData(String key) {
        return cache.getDataFromCache(key);
    }

    private static ConcurrentCache<String, String> createMap() {
        return new ConcurrentCacheImpl<>(new HashMap<>());
    }
}
