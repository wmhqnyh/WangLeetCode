package com.wangmh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : wang.mh
 * @date : 2022/9/8 23:48
 * <p>
 * 全排列II
 */
public class LeetCode_0047 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        Solution_0047 solution_0047 = new Solution_0047();
        List<List<Integer>> permuteUnique = solution_0047.permuteUnique(nums);
        for (List<Integer> integerList : permuteUnique) {
            for (Integer result : integerList) {
                System.out.println(result);
            }
            System.out.println("---------------------------------");
        }
    }

}


class Solution_0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length == 0) return result;
        int l = nums.length;
        Arrays.sort(nums);
        boolean[] visited = new boolean[l];
        helper(nums, 0, result, visited);
        return result;
    }

    private List<Integer> temp = new ArrayList<>();

    private void helper(int[] nums, int level, List<List<Integer>> result, boolean[] visited) {
        int length = nums.length;
        if (level == length) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                temp.add(nums[i]);
                helper(nums, level + 1, result, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
