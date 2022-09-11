package com.wangmh.leetcode;

/**
 * @author : wang.mh
 * @date : 2022/9/11 23:30
 * <p>
 * 最大子数组和
 * <a href="https://leetcode.cn/problems/maximum-subarray/">...</a>
 */
public class LeetCode_0053 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution_0053 solution_0053 = new Solution_0053();
        int maxValue = solution_0053.maxSubArray(nums);
        System.out.println(maxValue);
    }
}

class Solution_0053 {
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
