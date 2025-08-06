package com.wmy.linkedList;

import com.wmy.ListNode;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 想象基于三个连续三个节点去反转
        ListNode cur = head; // 当前节点 即 第一个节点
        ListNode next = head.next; // 下一个节点 即 第二个节点
        cur.next = null; // 当前节点的next指向null 循环外第一个节点的next指向null

        while (next != null) { // 循环条件 ：下一个节点不为null
            ListNode temp = next.next; // 临时节点 下下个节点 即 第三个节点
            next.next = cur; // 下一个节点的next指向当前节点 第二个节点的next指向第一个节点
            cur = next; // 当前节点指向下一个节点 第一个节点变量移动到第二个节点
            next = temp; // 下一个节点指向临时节点 第三个节点变量移动到第三个节点
        }

        return cur;
    }
}
