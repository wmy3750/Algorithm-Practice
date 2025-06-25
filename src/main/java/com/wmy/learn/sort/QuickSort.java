package com.wmy.learn.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author wmy
 * @date 2025/06/25
 *
 * 快速排序的思想其实是分支
 *
 * 1. 确定分界点， 可以是随机，也可以是中间的数，也可以是第一个数，也可以是最后一个数
 * 2. 确定分界点之后，将数组分为两个部分，小于分界点的数，大于分界点的数   这是最难的地方
 * 3. 递归调用
 */
public class QuickSort {
    public int[] quickSort(int[] nums) {
//        quicksortByLeft(nums, 0, nums.length - 1);
//        quicksortByRight(nums, 0, nums.length - 1);
//        quicksortByMiddle(nums, 0, nums.length - 1);
        quicksortByRandom(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksortByRandom(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partitionByRandom1(nums, left, right);
            quicksortByRandom(nums, left, partition - 1);
            quicksortByRandom(nums, partition + 1, right);
        }
    }

    private int partitionByRandom(int[] nums, int left, int right) {
        int random = (int) (Math.random() * (right - left + 1)) + left;
        int pivot = nums[random];
        swap(nums, random, right);
        int i = left, j = right - 1;

        while (true) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }

            while (i <= j && nums[j] >= pivot) {
                j--;
            }

            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            } else {
                break;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private int partitionByRandom1(int[] nums, int left, int right) {
        int random = (int) (Math.random() * (right - left + 1)) + left;
        int pivot = nums[random];
        swap(nums, random, right);
        int i = left, j = right - 1;

        while (i <= j) {
            if (nums[i] <= pivot) {
                i++;
            } else if (nums[j] >= pivot) {
                j--;
            } else {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void quicksortByMiddle(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partitionByMiddle(nums, left, right);
            quicksortByMiddle(nums, left, partition - 1);
            quicksortByMiddle(nums, partition + 1, right);
        }
    }

    private int partitionByMiddle(int[] nums, int left, int right) {
        int mid = left + ((right - left) >> 1);
        int pivot = nums[mid];
        swap(nums, mid, right);
        int i = left, j = right - 1;
        while (true) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }

            while (i <= j && nums[j] >= pivot) {
                j--;
            }

            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            } else {
                break;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void quicksortByRight(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partitionByRight(nums, left, right);
            quicksortByRight(nums, left, partition - 1);
            quicksortByRight(nums, partition + 1, right);
        }
    }

    private int partitionByRight(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left, j = right - 1;

        while (true) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }

            while (i <= j && nums[j] >= pivot) {
                j--;
            }

            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            } else {
                break;
            }
        }
        swap(nums, i, right);
        return i;
    }

    public void quicksortByLeft(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partitionByLeft(nums, left, right); // 分界点
            quicksortByLeft(nums, left, partition - 1);
            quicksortByLeft(nums, partition + 1, right);
        }
    }

    private int partitionByLeft(int[] nums, int left, int right) {
        int pivot = nums[left]; // 分界点
        int i = left + 1; // 分界点右边的数
        int j = right; // 分界点左边的数

        while (true) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            } else {
                break;
            }
        }
        swap(nums, left, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {3, 5, 4, 3, 2, 1};
        System.out.printf("排序前的数组：" + Arrays.toString(nums) + "\n");
        int[] res = quickSort.quickSort(nums);
        System.out.printf("排序后的数组：" + Arrays.toString(res) + "\n");
    }
}
