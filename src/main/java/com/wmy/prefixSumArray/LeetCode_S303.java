package com.wmy.prefixSumArray;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S303 {

    private int[] preNums;

    public LeetCode_S303(int[] nums) {
        preNums = new int[nums.length];
        preNums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? preNums[right] : preNums[right] - preNums[left - 1];
    }

    /*private int[] nums;
    public LeetCode_S303(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
           sum += nums[i];
        }
        return sum;
    }*/
}
