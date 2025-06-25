package com.wmy.learn.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author wmy
 * @date 2025/06/25
 *
 * 步骤：
 * 1. 确定递归终止条件
 * 2. 找到mid值
 * 3. 左右递归
 * 4. merge  这个过程是 两个以mid为界的数组，谁小谁先放在help数组中，
 *           直到左右两个数组都为空 然后吧剩下没放完的数组直接全部放进去
 *           把help数组的元素复制给nums数组  注意从左边界开始复制
 *
 *           可以想象成二叉树一样，每次merge只是一次局部有序，递归回溯时，
 *           上一步merge的数组要和新的数组再次merge，所以要从左边界开始
 *           可以想象递归到第一次分裂的右边界数组，那么left就不可能是0，而是left变量传进去
 */
public class MergeSort {
    public int[] mergeSort(int[] nums) {
        process(nums, 0, nums.length - 1);
        return nums;
    }

    private void process(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = left + ((right - left) >> 1);

        process(nums, left, mid);
        process(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0, p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }

        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }

        while (p2 <= right) {
            help[i++] = nums[p2++];
        }
        for (i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 3, 2, 1 };
        System.out.printf("排序前的数组：" + Arrays.toString(nums) + "\n");
        MergeSort mergeSort = new MergeSort();
        int[] res = mergeSort.mergeSort(nums);
        System.out.printf("排序后的数组：" + Arrays.toString(res) + "\n");
    }
}
