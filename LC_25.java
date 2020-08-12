package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-10  19:47
 */
public class LC_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        //空节点作为头
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            //迭代k次
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = null;
        ListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
