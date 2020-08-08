package com.cheerway.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-05  22:23
 */
public class LRUCache<K,V> {
    private final Map<K, V> cache = new LinkedHashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /* 将某个 key 提升为最近使用的 */
    public void makeRecently(K key) {
        V value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
        }

        if (cache.size() >= this.capacity) {
            K oldestKey = cache.keySet().iterator().next();
            cache.remove(key);
        }
        cache.put(key, value);
    }
}
