
package com.wmy.array.removeElements;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S283 {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        for (; fast< nums.length; fast++) {
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
