package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-17  20:49
 */
public class LC_202 {
    //参考英文网站热评第一。这题可以用快慢指针的思想去做，有点类似于检测是否为环形链表那道题
    //如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是
    //两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = helper(slow);
            fast = helper(fast);
            fast = helper(fast);
        }while (fast != slow);

        return fast == 1;
    }

    private int helper(int m) {
        int temp = 0;
        while (m != 0) {
            temp += (m%10) * (m%10);
            m /= 10;
        }
        return temp;
    }
}
