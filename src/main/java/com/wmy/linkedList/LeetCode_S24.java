package com.wmy.linkedList;

import com.wmy.ListNode;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftNode = head; // 左节点
        ListNode rightNode = head.next; // 右节点
        leftNode.next = swapPairs(rightNode.next); // 递归处理 左节点的next指向递归返回的节点
        rightNode.next = leftNode; // 右节点的next指向左节点
        return rightNode; // 递归返右节点，因为递归外侧连接的是右节点
    }
}
