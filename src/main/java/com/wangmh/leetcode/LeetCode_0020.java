package com.wangmh.leetcode;

import java.util.Stack;

/**
 * @author : wang.mh
 * @date : 2022/9/11 23:13
 * <p>
 * 有效的括号
 * <a href="https://leetcode.cn/problems/valid-parentheses/">...</a>
 */
public class LeetCode_0020 {
    public static void main(String[] args) {
        String testString = "()[]{}";
        Solution_0020 solution_0020 = new Solution_0020();
        boolean valid = solution_0020.isValid(testString);
        System.out.println(valid);
    }
}

class Solution_0020 {
    public boolean isValid(String s) {
        if (null == s || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (aChar == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (aChar == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }
}
