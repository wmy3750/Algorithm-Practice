
package com.wmy.array.removeElements;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
