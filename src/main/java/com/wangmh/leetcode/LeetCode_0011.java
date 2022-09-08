package com.wangmh.leetcode;

/**
 * @author : wang.mh
 * @date : 2022/9/9 00:23
 * <p>
 * 盛水最多的容器
 * * <a href="https://leetcode.cn/problems/container-with-most-water/">...</a>
 */
public class LeetCode_0011 {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution_0011 solution_0011 = new Solution_0011();
        int result = solution_0011.maxArea(height);
        System.out.println(result);
    }
}

class Solution_0011 {
    public int maxArea(int[] height) {
        if (null == height || height.length == 0) return 0;
        int i = 0, len = height.length - 1, res = 0;
        while (i < len) {
            int h = Math.min(height[i], height[len]);
            res = Math.max(res, (len - i) * h);
            if (height[i] < height[len]) i++;
            else len--;
        }
        return res;
    }

}
