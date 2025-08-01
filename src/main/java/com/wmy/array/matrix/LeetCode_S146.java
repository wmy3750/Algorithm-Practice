package com.wmy.array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S146 {
    public int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int m = array.length, n = array[0].length;
        int[] res = new int[m * n];
        int k = 0;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (true) {
            for (int i = left; i <= right; i++)  res[k++] = array[top][i];
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++)  res[k++] = array[i][right];
            if (--right < left) break;
            for (int i = right; i >= left; i--)  res[k++] = array[bottom][i];
            if (--bottom <  top) break;
            for (int i = bottom; i >= top; i--)  res[k++] = array[i][left];
            if (++left > right) break;
        }
        return res;
    }
}
