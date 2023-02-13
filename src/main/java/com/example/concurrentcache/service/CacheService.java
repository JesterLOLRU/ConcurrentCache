package com.example.concurrentcache.service;

public interface CacheService {

    void putData(String key, String value);

    String getData(String key);
}
