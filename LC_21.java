package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-12  19:45
 */
public class LC_21 {

    /* 迭代法 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        //如果不赋值给curr，用dummyHead代替curr去做迭代的话，那dummyHead最终指向的是l1或l2的尾节点,无法正确返回
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            //比如1->2->4 , 1->3->4 这两个，第一次循环以后curr会变成 -1->1(来自于第二个链表)->3->4
            //下一次应该用1(来自于第二个链表的)去连接下一个节点，所以要curr = curr.next;
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    /* 递归法 */
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_1(l2, l1.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2; l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5; l5.next = l6;

        new LC_21().mergeTwoLists(l1, l4);
    }
}
