package com.cheerway.leetcode;

import sun.misc.Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-05  21:33
 */
class Node{
    int key;
    int value;
    public Node next, pre;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleList{
    //头尾虚节点
    private Node head, tail;
    //记录链表的大小
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    //在链表的尾部添加元素  O(1)
    public void addLast(Node x) {
        x.pre = tail.pre;
        x.next = tail;
        tail.pre.next = x;
        tail.pre = x;
        size++;
    }

    //删除链表中的某个节点  O(1)  单向链表不支持O(1)的删除
    public void remove(Node x) {
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    //删除链表头部节点的值  O(1)
    public Node removeFirst() {
        if (head.next == tail)
            return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }
}
public class LRU_1 {

    //哈希表映射节点的位置
    private Map<Integer, Node> map;
    //存储结构
    private DoubleList cache;
    //容量大小
    private int capacity = 0;

    public LRU_1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    //先不慌去实现 LRU 算法的 get 和 put 方法。由于我们要同时维护一个双链表 cache 和一个哈希表 map，很容易漏掉一些操作，
    // 比如说删除某个 key 时，在 cache 中删除了对应的 Node，但是却忘记在 map 中删除 key。
    //解决这种问题的有效方法是：在这两种数据结构之上提供一层抽象 API。
    //说的有点玄幻，实际上很简单，就是尽量让 LRU 的主方法 get 和 put 避免直接操作 map 和 cache 的细节。我们可以先实现下面几个函数：

    /* 将某个 key 提升为最近使用的 */
    private void makeRecently(int key) {
        Node x = map.get(key);
        //先删除
        cache.remove(x);
        //再插入队尾
        cache.addLast(x);
    }

    /* 添加最近使用的元素 */
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        //添加到队尾
        cache.addLast(x);
        //添加到映射
        map.put(key, x);
    }

    /* 删除某一个 key */
    private void deleteKey(int key) {
        Node x = map.get(key);
        //从链表中删除
        cache.remove(x);
        //从映射中删除
        map.remove(key);
    }

    /* 删除最久未使用的元素 */
    private void removeLeastRecently() {
        // 链表头部的第一个元素就是最久未使用的
        Node x = cache.removeFirst();
        // 同时别忘了从 map 中删除它的 key
        map.remove(x.key);
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        makeRecently(key);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 删除旧的数据
            deleteKey(key);
            // 新插入的数据为最近使用的数据
            addRecently(key, value);
            return;
        }

        if (capacity == cache.getSize()) {
            //删除最近最少使用的
            removeLeastRecently();
        }
        //添加节点
        addRecently(key, value);
        
    }

}
