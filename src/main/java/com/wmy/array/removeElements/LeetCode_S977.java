
package com.wmy.array.removeElements;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            int x = nums[i];
            int y = nums[j];
            if (-x > y) {
                res[p] = x * x;
                i++;
            } else {
                res[p] = y * y;
                j--;
            }
        }
        return res;
    }
}


