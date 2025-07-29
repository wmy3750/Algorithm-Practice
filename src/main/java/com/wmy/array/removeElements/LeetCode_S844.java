
package com.wmy.array.removeElements;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S844 {
    public boolean backspaceCompare(String s, String t) {
       /* Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
        }

        return stack1.equals(stack2) ? true : false;*/
        int i = s.length() - 1, j = t.length() - 1; // 指向 s和t 的末尾
        int skipS = 0, skipT = 0; // s和t 中的退格字符数量

        while (i >= 0 || j >= 0) { // 遍历两个字符串，直到两个指针都遍历到字符串的开头
            while (i >= 0) { // 处理 s 中的退格字符
                if (s.charAt(i) == '#') {
                    skipS++; // 遇到退格字符，增加退格计数
                    i--; // 跳过退格字符
                } else if (skipS > 0) {
                    skipS--; // 退格字符--
                    i--; // 跳过当前字符
                } else {
                    break; // 当前字符有效，退出循环
                }
            }

            while (j >= 0) { // 处理 t 中的退格字符
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // 如果两个字符串的当前字符不相等，返回 false
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            // 如果一个字符串已经遍历完，而另一个字符串还有有效字符，返回 false
            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            // 移动指针到下一个字符
            i--;
            j--;
        }
        return true;
    }
}
