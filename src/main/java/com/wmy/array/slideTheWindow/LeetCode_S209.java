
package com.wmy.array.slideTheWindow;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, count = Integer.MAX_VALUE;
        int left = 0, right = 0;
        for (; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) { //滑动窗口核心  缩小窗口
                sum -= nums[left];
                count = Math.min(count, right - left + 1);
                left++;
            }
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
