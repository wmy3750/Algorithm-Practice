package com.wmy.prefixSumArray;

import cn.hutool.json.JSONUtil;
import com.wmy.DifferenceArrayUtils;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        DifferenceArrayUtils differenceArrayUtils = new DifferenceArrayUtils(diff);

        for (int[] book : bookings) {
            int i = book[0] - 1;
            int j = book[1] - 1;
            int k = book[2];
            differenceArrayUtils.increment(i, j, k);
        }

        return differenceArrayUtils.result();
    }

    public static void main(String[] args) {
        LeetCode_S1109 solution = new LeetCode_S1109();
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] result = solution.corpFlightBookings(bookings, n);
        System.out.println(JSONUtil.toJsonPrettyStr(result));
    }
}
