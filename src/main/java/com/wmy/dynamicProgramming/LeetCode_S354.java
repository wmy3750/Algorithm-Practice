package com.wmy.dynamicProgramming;

import java.util.Arrays;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length != 2) return 0;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
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
     * 和300这题类似，状态转移方程是dp[i] = Math.max(dp[i], dp[j] + 1)
     * 但需要注意先按照宽度排序在按照长度排序，排完序就和300这题一样了
     */
    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        LeetCode_S354 leetCode_s354 = new LeetCode_S354();
        System.out.println(leetCode_s354.maxEnvelopes(envelopes));
    }
}
