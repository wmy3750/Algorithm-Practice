package com.wmy.linkedList;

import com.wmy.ListNode;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode cur = tempHead;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return tempHead.next;
    }
}
