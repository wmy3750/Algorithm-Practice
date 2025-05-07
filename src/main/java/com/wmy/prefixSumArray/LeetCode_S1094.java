package com.wmy.prefixSumArray;

import com.wmy.DifferenceArrayUtils;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        DifferenceArrayUtils differenceArrayUtils = new DifferenceArrayUtils(new int[1001]);
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            int value = trip[0];
            int i = trip[1]; // 注意左区间是从0开始
            int j = trip[2] - 1;

            differenceArrayUtils.increment(i, j, value);
           /* diff[i] += value;
            if (j + 1 < diff.length) {
                diff[j + 1] -= value;
            }*/
        }

        int[] res = differenceArrayUtils.result();
        for (int i = 0; i < res.length; i++) {
            if (res[i] > capacity) {
                return false;
            }
        }
       /* int[] res = new int[diff.length];
        res[0] = diff[0];

        // 注意第一个元素也要校验
        if (res[0] > capacity) {
            return false;
        }
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
            if (res[i] > capacity) {
                return false;
            }
        }*/

        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,5,7}};
        int capacity = 3;
        LeetCode_S1094 leetCode_s1094 = new LeetCode_S1094();
        boolean b = leetCode_s1094.carPooling(trips, capacity);
        System.out.println(b);
    }
}
