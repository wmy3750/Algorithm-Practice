package com.wmy.dynamicProgramming;

import java.util.Arrays;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S322 {
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);

        return dp(coins, amount);
    }

    // dp 数组的迭代解法 自下向上
    private int dp(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                int targetCoin = i - coin;
                if (targetCoin >= 0) {
                    dp[i] = Math.min(dp[i], dp[targetCoin] + 1);
                }
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

    // 备忘录递归 自顶向下
    int[] memo;
    private int dpMemorandumRecursion(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        // 查备忘录，防止重复计算
        if (memo[amount] != -666) return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int targetCoin = amount - coin;
            int subProblem = dpMemorandumRecursion(coins, targetCoin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    /* // 暴力递归
    private int dpViolentRecursion(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int targetCoin = amount - coin;
            int subProblem = dpViolentRecursion(coins, targetCoin);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }*/

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        LeetCode_S322 leetCode_s322 = new LeetCode_S322();
        int res = leetCode_s322.coinChange(coins, amount);
        System.out.println(res);
    }
}
