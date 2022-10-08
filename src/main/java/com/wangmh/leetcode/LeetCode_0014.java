package com.wangmh.leetcode;

/**
 * @author : wang.mh
 * @date : 2022/10/08 23:50
 * <p>
 * 最长公共前缀
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">...</a>
 */
public class LeetCode_0014 {

    public static void main(String[] args) {
        Solution_0014 solution_0014 = new Solution_0014();
        String[] strings = new String[]{"flower", "flow", "flight"};
        String s = solution_0014.longestCommonPrefix(strings);
        System.out.println(s);
    }
}

class Solution_0014 {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }
}
