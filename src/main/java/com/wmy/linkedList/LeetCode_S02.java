package com.wmy.linkedList;

import com.wmy.ListNode;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个虚拟头结点 方便后续操作
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        // 初始化进位为0
        int carry = 0;

        // 循环遍历
        while (l1 != null || l2 != null) {
            // 当链接遍历完时,默认值是0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            // 计算当前节点的值
            int sum = x + y + carry;

            // 更新进位
            carry = sum / 10;

            // 创建当前节点
            cur.next = new ListNode(sum % 10);

            // 移动指针
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            // 循环结束后,判断是否还有进位
            if (carry > 0) {
                cur.next = new ListNode(carry);
            }
        }

        return dummy.next;
    }
}
