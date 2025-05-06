package com.wmy.doublepointers;

/**
 * @author wangmengyao
 * @Date 2025/4/15 15:06
 */


public class LeetCode_S42 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int res = 0;
        // 左右边界接不到水直接过
        left++;
        right--;

        while (left <= right) {
            // 分别计算左右指针移动过程中的板子最大高度
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 木桶效应，左侧最大高度小于右侧最大，则res += 做最大高度-当前的左指针位置
            if (leftMax <= rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax  - height[right];
                right--;
            }
        }
        return res;
    }
}

