package com.wmy.stackAndqueue;

import java.util.Stack;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[')
                stack.pop();
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{')
                stack.pop();
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
