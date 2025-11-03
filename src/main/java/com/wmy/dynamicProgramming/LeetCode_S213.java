package com.wmy.dynamicProgramming;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(nums[0] + climbStairs(nums, 2, n - 2), climbStairs(nums, 1, n - 1));
    }

    public int climbStairs(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int dp[] = new int[nums.length];
        dp[start] = nums[start];
        for (int i = start + 1; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
