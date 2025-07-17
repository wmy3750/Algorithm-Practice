package com.wmy.other.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S56 {
    public int[][] merge(int[][] intervals) {
        // 1. 排序：左端点升序，左端点一样时右端点升序
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<int[]> res = new ArrayList<>();// 用来存合并后的区间

        // 2. 先放第一个区间进去
        int[] cur = intervals[0];
        int start = cur[0];
        int end = cur[1];

        // 3. 从第二个区间开始扫描
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (nextStart <= end) {
                // 能合并：把右端点拉大
                end = Math.max(end, nextEnd);
            } else {
                // 不能合并：把当前区间收进答案，开启新区间
                res.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            }
        }
        // 4. 把最后一个区间也收进去
        res.add(new int[]{start, end});

        // 5. 转成二维数组返回
        return res.toArray(new int[res.size()][]);
    }
}
