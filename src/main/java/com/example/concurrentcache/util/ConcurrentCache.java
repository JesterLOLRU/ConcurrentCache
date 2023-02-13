package com.example.concurrentcache.util;

public interface ConcurrentCache<K,V> {

    V putDataToCache(K key, V value);

    V getDataFromCache(K key);
}
