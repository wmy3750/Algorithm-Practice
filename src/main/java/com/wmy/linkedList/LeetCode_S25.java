package com.wmy.linkedList;

import com.wmy.ListNode;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 创建虚拟节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 先知道链表的长度 用于判断链表是否可以翻转
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        // 和反转链表II同理操作
        ListNode p0 = dummy, pre = null, next = null;
        cur = p0.next;

        // 翻转k个节点 不足就结束循环
        while (n >= k) {
            n -= k;
            // 翻转k个节点 和反转链表I同理操作
            for (int i = 0; i < k; i++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            // 关键要让p0指向每次反转的前一个节点
            // 用next先记录p0的下一个节点
            next = p0.next;
            // p0的下一个节点的next指向第二个反转链表的头结点
            p0.next.next = cur;
            // p0的next指向 反转前pre指向的节点
            p0.next = pre;
            // p0移动到下一次反转链表的上一个节点  以便下次循环
            p0 = next;
        }
        return dummy.next;
    }
}
