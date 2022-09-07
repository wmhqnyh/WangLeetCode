package com.wangmh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wang.mh
 * @date : 2022/9/7 14:39
 * <p>
 * 全排列，元素不重复
 */
public class LeetCode_0046 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution_0046 solution_0046 = new Solution_0046();
        List<List<Integer>> permute = solution_0046.permute(nums);
        for (List<Integer> integerList : permute) {
            for (Integer result : integerList) {
                System.out.println(result);
            }
            System.out.println("---------------------------------");
        }
    }
}

class Solution_0046 {

    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length == 0) return result;
        int l = nums.length;
        boolean[] visited = new boolean[l];
        helper(nums, 0, result, visited);
        return result;
    }

    public void helper(int[] nums, int level, List<List<Integer>> result, boolean[] visited) {
        int length = nums.length;
        if (level == length) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                helper(nums, level + 1, result, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}