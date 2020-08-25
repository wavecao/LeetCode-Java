package com.cheerway.leetcode;

import java.util.Stack;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-24  21:32
 */
public class LC_232 {

    int front;
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    /** Push element x to the back of queue. */
    //O(1)
    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()) {
            //相当于把s1的元素反序压入s2，那么s2最上面的元素就是队列头的值
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        //如果s2有元素，说明front已经被弹出”失效“了
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
