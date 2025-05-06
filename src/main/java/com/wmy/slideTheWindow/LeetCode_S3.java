package com.wmy.slideTheWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangmengyao
 * @Date 2025/4/15 15:06
 */


public class LeetCode_S3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s == "") return 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 只要当前的字符出现次数大于1，则左边界++直到没有大于1为止
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            // 左边界移动完，记录最大长度
            res = Math.max(res, right - left);
        }
        return res;
    }
}

