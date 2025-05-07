package com.wmy;

/**
 * @author wangmengyao
 * @Date 2025/5/7 10:26
 */
// 差分数组工具类
public class DifferenceArrayUtils {

    // 差分数组
    private int[] diff;

    // 构造函数
    public DifferenceArrayUtils(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    // 对差分数组进行更新
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    // 根据差分数组构造原数组
    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
