
package com.wmy.other;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            ans[i] *= temp;
        }
        return ans;

        /*
            原数组：       [1       2       3       4]
            左部分的乘积：   1       1      1*2    1*2*3
            右部分的乘积： 2*3*4    3*4      4      1
            结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
         */
    }
}
