package me.antonle.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    /**
     * 1. Sort the array??
     */
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumTwoPointers(nums);
    }

    /**
     * Time complexity -> O(N^2 * log(N))
     * Sort: [-1, 0, 1, 2, -1, -4] -> [-4, -1, -1, 0, 1, 2]
     * nums[i] + nums[j] + nums[k] = 0
     */
    public List<List<Integer>> threeSumA(int[] nums) {
        Arrays.sort(nums); // O(N*logN) -> quicksort
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; j > i + 1; j--) {
                if (nums[j] < 0) {
                    break;
                }
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                final int targetNum = -(nums[i] + nums[j]);
                final int k = Arrays.binarySearch(nums, i + 1, j, targetNum);
                if (k > 0) {
                    final List<Integer> threeSum = List.of(nums[i], nums[k], nums[j]);
                    res.add(threeSum);
                }
            }
        }
        return res;
    }

    /**
     * Time complexity -> O(N^3)
     * Sort: [-1, 0, 1, 2, -1, -4] -> [-4, -1, -1, 0, 1, 2]
     * nums[i] + nums[j] + nums[k] = 0
     */
    public List<List<Integer>> threeSumTwoPointers(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answers = new ArrayList<>();

        // 2 pointers situation
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (lo > i + 1 && nums[lo] == nums[lo - 1]) {
                    lo++;
                    continue;
                }

                if (hi < nums.length - 1 && nums[hi] == nums[hi + 1]) {
                    hi--;
                    continue;
                }


                if (nums[lo] + nums[hi] + num == 0) {
                    answers.add(List.of(num, nums[lo], nums[hi]));
                }
                // [-4, -1, -1, 0, 1, 2]
                if (nums[lo] + nums[hi] + num > 0) {
                    hi--;
                } else {
                    lo++;
                }
            }

        }
        return answers;
    }
}
