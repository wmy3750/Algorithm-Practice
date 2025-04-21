package com.wmy.dynamicProgramming;

import java.util.Arrays;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S509 {
    /*// 暴力求解
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }*/

    /*// 备忘录 自顶向下递归
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] memo = new int[n + 1];
        return dp(n, memo);
    }

    private int dp(int n, int[] memo) {
        if (n == 0 || n == 1) return n;
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = dp(n - 1, memo) + dp(n - 2, memo);
        return memo[n];
    }*/

    // 动态规划 自底向上
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        LeetCode_S509 leetCode_s509 = new LeetCode_S509();
        System.out.println(leetCode_s509.fib(10));
    }
}
