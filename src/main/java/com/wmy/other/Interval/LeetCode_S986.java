package com.wmy.other.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int l = 0, r = 0;
        List<int[]> res = new ArrayList<>();
        while (l < firstList.length && r < secondList.length) {
            int[] leftList = firstList[l];
            int[] rightList = secondList[r];
            int left = Math.max(leftList[0], rightList[0]);
            int right = Math.min(leftList[1], rightList[1]);

            if (left <= right) {
                res.add(new int[]{left, right});
            }
            if (leftList[1] < rightList[1]) {
                l++;
            } else {
                r++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
