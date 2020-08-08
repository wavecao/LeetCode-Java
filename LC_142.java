package com.cheerway.leetcode;

/**
 * <pre>
 *能运行到这里说明链表有环，假设环开始节点距离起点距离为a，换开始节点到两指针相遇的位置为b，链表长度为l, 则有以下推导：
 *      快指针走过的距离为：l+b
 *      慢指针走过的距离为：a+b
 *      有环说明快指针走过的距离是慢指针走过的距离的两倍，所以有
 *      l+b = 2(a+b)
 *      可得：l-a = a+b
 *      这个等式的意思是，链表中环的长度为a+b，相遇之处距离环起点为b，所以只需要再走a就可以到达环起点
 *      巧的是，链表起点到环起点的距离也是a，我们只需要让其中一个指针指向链表起点，再让两指针以相同的速率前进，相遇的地方就是
 *      环的起点！
 * </pre>
 *
 * @author : 曹威
 * @since : 2020-08-03  21:32
 */
public class LC_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast, slow;
        fast = slow =head;
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
