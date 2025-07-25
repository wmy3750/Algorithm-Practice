package com.wmy.other;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S41 {
    // 当做一种小游戏，把每个数字放到它家的位置，然后从左到右看谁家空着
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 // 数字得大于0
                    && nums[i] <= nums.length // 数字得在1~n之间
                    && nums[i] != nums[nums[i] - 1]) { // 数字不在自己家中
                swap(nums, i, nums[i] - 1); // 把数字送回家
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) { // 谁家空着
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
