package com.cheerway.leetcode.again;

import sun.misc.Unsafe;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-13  22:06
 */
public class LRUCache {
    private Map<Integer, Integer> cache = new LinkedHashMap<>();

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /* 将某个 key 提升为最近使用的 */
    private void makeRecently(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.capacity) {
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
    }
}
