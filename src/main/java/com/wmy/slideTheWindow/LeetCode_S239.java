package com.wmy.slideTheWindow;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author wangmengyao
 * @Date 2025/4/15 15:06
 */


public class LeetCode_S239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int j = 0, i = 1 - k; j < n; i++, j++) {
            // 窗口左边界的左边值与单调队列最大值相等，则需要移除单调队列首元素
            if (i > 0 && !deque.isEmpty() && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 只要队尾元素比当前值小，就移除队尾
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            // 每次加入单调队列
            deque.add(nums[j]);
            // 当滑动窗口左边界形成则记录返回值res
            if (i >= 0) res[i] = deque.peekFirst();
        }
        return res;
    }
}

