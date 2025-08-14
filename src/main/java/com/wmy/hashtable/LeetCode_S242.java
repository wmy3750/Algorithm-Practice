package com.wmy.hashtable;

import java.util.*;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> need = new HashMap<>();

        for (char c : s.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) - 1);
        }

        for (int count : need.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
