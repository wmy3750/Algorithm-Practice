package com.wmy.dynamicProgramming;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S70 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode_S70 leetCode_s70 = new LeetCode_S70();
        System.out.println(leetCode_s70.climbStairs(5));
    }
}
