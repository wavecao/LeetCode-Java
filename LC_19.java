package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-15  20:01
 */
public class LC_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        //快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //fast走到了结尾，说明n 等于链表的长度，所以要删除的是头节点
        if (fast == null) return head.next;
        //快指针走到尾节点的时候，慢指针恰好到倒数第n个
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
