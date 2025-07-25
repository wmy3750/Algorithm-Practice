package com.wmy.other;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 旋转45%就会发现类似二叉搜索树的结构
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
        // 笨方法
        /* if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    break;
                } else if (matrix[i][j] < target) {
                    continue;
                }
            }
        }
        return false;*/
    }
}
