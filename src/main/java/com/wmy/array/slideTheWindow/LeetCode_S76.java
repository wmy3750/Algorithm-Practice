package com.wmy.array.slideTheWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0; // 用于记录墓表子串的真实长度
        int left = 0, right = 0; // 滑动窗口的左右边界
        int start = 0, len = Integer.MAX_VALUE; // 记录最小覆盖子串的起始位置和长度
        for (char c : t.toCharArray()) { // 初始化need
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()) { // 移动右边界
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) { // 如果c是子串的字符 才加入窗口
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) { // 如果窗口的字符数量和need的字符数量相等，则valid++
                    valid++;
                }
            }
            while (valid == need.size()) { // 只有valid这个真是长度满足才能确定当前窗口的子串
                if (right - left < len) { // 满足则更新最小覆盖子串的起始位置和长度
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) { // 如果d是子串的
                    if (window.get(d).equals(need.get(d))) { // 如果窗口的d的数量和need的d的数量相等，则valid--
                        valid--;
                    }
                    window.put(d, window.get(d) - 1); // 窗口的d数量减1
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len); // 返回最小覆盖子串
    }
}
