package com.example.concurrentcache.util;

import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentCacheImpl<K, V> implements ConcurrentCache<K,V> {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock getLock = lock.readLock();
    private final Lock putLock = lock.writeLock();

    private final Map<K, V> cacheMap = new ConcurrentReferenceHashMap<>();
    private final Map<K, V> map;

    private static final ExecutorService concurrentService = Executors.newCachedThreadPool();

    public ConcurrentCacheImpl(Map<K, V> storage) {
        this.map = storage;
    }

    public V getDataFromCache(K key) {
        getLock.lock();

        try {
            V result;
            if (cacheMap.containsKey(key)) {
                result = cacheMap.get(key);
            } else {
                result = getPairFromMap(key);
            }
            return result;
        } finally {
            getLock.unlock();
        }
    }

    public V putDataToCache(K key, V value) {
        putLock.lock();

        try {
            V result = cacheMap.put(key, value);
            concurrentService.submit(() -> putPairToMap(key, value));
            return result;
        } finally {
            putLock.unlock();
        }
    }

    private V getPairFromMap(K key) {
        return map.get(key);
    }

    private void putPairToMap(K key, V value) {
        map.put(key, value);
    }

}
