package com.wmy.prefixSumArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S560 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0, sum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int dif = sum - k;
            if (countMap.containsKey(dif)) {
                res += countMap.get(dif);
            }
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    /*// 动态规划但是暴力了
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
           dp[i + 1] = dp[i] + nums[i];
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] - dp[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }*/

    /*// 暴力求解
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }*/
}
