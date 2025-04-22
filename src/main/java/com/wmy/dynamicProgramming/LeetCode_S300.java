package com.wmy.dynamicProgramming;

import java.util.Arrays;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    /*
     * 数学归纳法
     * 无序数组找递增子序列，不难发现，当有n个数时，其最长子序列长度和前面比他小的max(m)子序列的长度有关，即dp[n] = max(dp[i]) + 1;
     * 递推公式：dp[n] = max(dp[i]) + 1;
     * 用该例子举例 10, 9, 2, 5, 3, 7, 101, 18
     * 下标为       0, 1, 2, 3, 4, 5,   6,  7
     * 则dp数组为   1, 1, 1, 2, 2, 3,   4,  4
     * 最后遍历得到最大值，即4
     */
    public static void main(String[] args) {
        LeetCode_S300 leetCode_s300 = new LeetCode_S300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(leetCode_s300.lengthOfLIS(nums));
    }
}
