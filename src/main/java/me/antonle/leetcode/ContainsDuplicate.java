package me.antonle.leetcode;

import me.antonle.leetcode.util.Solution;

import java.util.Arrays;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {

    @Solution
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[++i]) {
                return true;
            }
        }
        return false;
    }
}
