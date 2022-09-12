package com.wangmh.leetcode;

/**
 * @author : wang.mh
 * @date : 2022/9/12 22:22
 * <p>
 * Z字变换
 * <a href="https://leetcode.cn/problems/zigzag-conversion/">...</a>
 */
public class LeetCode_0006 {
    public static void main(String[] args) {
        String testString = "PAYPALISHIRING";
        Solution_0006 solution_0006 = new Solution_0006();
        String convert = solution_0006.convert(testString, 3);
        System.out.println(convert);
    }
}

class Solution_0006 {
    public String convert(String s, int numRows) {
        if (null == s || s.length() == 0 || numRows <= 1) return "";
        if (s.length() <= numRows) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int index = 0;
        int direct = 1;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            sb[index].append(c);
            index += direct;
            if (index == 0 || index == (numRows - 1)) direct = -direct;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : sb) {
            result.append(stringBuilder);
        }
        return result.toString();
    }
}
