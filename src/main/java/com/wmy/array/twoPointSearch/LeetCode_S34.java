
package com.wmy.array.twoPointSearch;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        result[0] = findLeft(nums, target);
        if (result[0] == -1) {
            return result;
        }
        result[1] = findRight(nums, target);
        return result;
    }

    public int findLeft(int[] nums, int target) {
        int leftIndex = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l ) >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                leftIndex = mid;
                r = mid - 1;
            }
        }
        return leftIndex;
    }

    public int findRight(int[] nums, int target) {
        int rightIndex = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l ) >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                rightIndex = mid;
                l = mid + 1;
            }
        }
        return rightIndex;
    }
}
