package com.example.concurrentcache.util;

public interface ConcurrentCache<K,V> {

    V put(K key, V value);

    V get(K key);
}
