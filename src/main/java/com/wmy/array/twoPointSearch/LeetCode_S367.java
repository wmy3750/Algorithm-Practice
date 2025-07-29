
package com.wmy.array.twoPointSearch;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S367 {
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num;
        while (l <= r) {
            int mid = l + ((r - l ) >> 1);
            long midNum = (long) mid * mid;
            if (midNum > num) {
                r = mid - 1;
            } else if (midNum < num) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
