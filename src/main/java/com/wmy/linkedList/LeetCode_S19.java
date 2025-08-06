package com.wmy.linkedList;

import com.wmy.ListNode;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        // 找到倒数第n+1个节点 因为要删除倒数第n个节点 虚拟节点的作用是如果删除节点是头节点，则可以去删除头节点
        // 不用担心从虚拟头结点遍历不会找到n+1的位置，因为是while(fast != null)的条件不是while(fast != null && fast.next != null)
        ListNode target = findFromEnd(tempNode, n + 1);
        target.next = target.next.next;
        return tempNode.next;
    }

    /**
     * 关键方法，找到倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    private ListNode findFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
