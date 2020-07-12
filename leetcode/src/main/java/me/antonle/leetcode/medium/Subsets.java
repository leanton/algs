package me.antonle.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        allCombinations.add(Collections.emptyList());
        for (int i = 0; i < nums.length; i++) {
            int size = allCombinations.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newList = new ArrayList<>(allCombinations.get(j));
                newList.add(nums[i]);
                allCombinations.add(newList);
            }
        }
        return allCombinations;
    }

}
