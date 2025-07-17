package com.wmy.other.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        int start = cur[0];
        int end = cur[1];

        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (start <= nextStart && end >= nextEnd) {
                end = Math.max(end, nextEnd);
            } else {
                res.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            }
        }
        res.add(new int[]{start, end});
        return res.size();

        /* Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int l = 0, r = 0;
        int res = 0;
        // 这是自己的思路，最好算法按照自己想的来
        while (r < intervals.length) {
            if (intervals[l][0] <= intervals[r][0] && intervals[l][1] >= intervals[r][1]) {
            } else {
                l = r;
                res++;
            }
            r++;
        }
        return res + 1;*/


       /* Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        // 因为已经是排好序的了，只需要比较当前区间的右边界是否大于最大右边界即可
        int maxRight = 0;
        for (int[] interval : intervals) {
            if (interval[1] > maxRight) {
                res++;
                maxRight = interval[1];
            }
        }
        return res;*/
    }
}
