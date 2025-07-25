package com.wmy.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = l; i <= r; i++) res.add(matrix[t][i]); // left to right
            if (++t > b) break; // 上面一行的左到右走完,则t=t+1,t>b则跳出循环
            for (int i = t; i <= b; i++) res.add(matrix[i][r]); // top to bottom
            if (l > --r) break; // 右边一列的上到下走完,则r=r-1,l>r则跳出循环
            for (int i = r; i >= l; i--) res.add(matrix[b][i]); // right to left
            if (t > --b) break; // 下边一列的右到左走完,则b=b-1,t>b则跳出循环
            for (int i = b; i >= t; i--) res.add(matrix[i][l]); // bottom to top
            if (++l > r) break; // 左边一列的下到上走完,则l=l+1,l>r则跳出循环
        }
        return res;
    }
}
