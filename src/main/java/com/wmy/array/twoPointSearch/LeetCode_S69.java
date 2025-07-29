
package com.wmy.array.twoPointSearch;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S69 {
    public int mySqrt(int x) {
        int l = 0, r = x, res = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if ((long) mid * mid <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
