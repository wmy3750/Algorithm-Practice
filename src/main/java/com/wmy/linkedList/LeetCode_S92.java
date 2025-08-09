package com.wmy.linkedList;

import com.wmy.ListNode;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 创建虚拟节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 指定范围的前一个节点
        ListNode p0 = dummy;
        while (left > 1) {
            p0 = p0.next;
            left--;
            right--;
        }

        // 正常的反转链表的内容
        ListNode pre = null, cur = p0.next, next;
        while (right > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            right--;
        }

        // 巨关键的代码
        // 注意此时p0.next是反转链表的第一个节点(left的第一个节点),那么反转后它的next就是cur(right后的第一个节点)
        p0.next.next = cur;
        // p0.next指向反转后的第一个节点(即right那个节点)
        p0.next = pre;

        return dummy.next;
    }
}
