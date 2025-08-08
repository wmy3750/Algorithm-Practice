package com.wmy.linkedList;

import com.wmy.ListNode;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S234 {
    public boolean isPalindrome(ListNode head) {
        // 最优解是双指针找到中点,然后反转后续链表,再左右比对
        ListNode slow = head, fast = head;

        // 循环结束则slow是中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 开始反转后续链表了
        ListNode pre = null, next = null;
        while (slow != null) {
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        // 开始比对
        ListNode cur1 = head, cur2 = pre;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
        /*// 并非最优解 因为空间复杂度是O(n)了
        ListNode cur = head;
        ListNode cur1 = head;
        Stack<Integer> stack = new Stack<>();

        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        while (cur1 != null) {
            if (cur1.val != stack.pop()) {
                return false;
            }
            cur1 = cur1.next;
        }
        return true;*/
    }
}
