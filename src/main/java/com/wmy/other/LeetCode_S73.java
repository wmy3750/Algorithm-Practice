package com.wmy.other;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S73 {
    public void setZeroes(int[][] matrix) {

        // O(m+n)
        /* Set<Integer> row_set = new HashSet<>();
        Set<Integer> col_set = new HashSet<>();

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    row_set.add(i);
                    col_set.add(j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (row_set.contains(i) || col_set.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }*/
        int row = matrix.length;
        int col = matrix[0].length;
        boolean flag = false;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) flag = true; // 第一列是否为0
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0; // 第一行和第一列的0标记
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) { // 从最后一行开始
            for (int j = col - 1; j>= 1; j--) { // 从最后一列开始
                if (matrix[i][0] == 0 || matrix[0][j] == 0) { // 第一行或第一列的0标记
                    matrix[i][j] = 0;
                }
            }
            if (flag) {
                matrix[i][0] = 0;
            }
        }
    }
}
