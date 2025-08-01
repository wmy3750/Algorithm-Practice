package com.wmy.array.matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;
        int target = n * n;
        while (num <= target) {
            for (int i = left; i <= right; i++)  res[top][i] = num++;
            top++;
            for (int i = top; i <= bottom; i++) res[i][right] = num++;
            right--;
            for (int i = right; i >= left; i--) res[bottom][i] = num++;
            bottom--;
            for (int i = bottom; i >= top; i--) res[i][left] = num++;
            left++;
        }
        return res;
    }
}
