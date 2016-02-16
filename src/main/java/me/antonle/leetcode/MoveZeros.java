package me.antonle.leetcode;


import me.antonle.leetcode.util.Solution;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12],
 * after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeros {

    @Solution
    public int[] moveZeroes(int[] nums) {
        int startZeroIndex = 0;
        boolean zeroInArray = false;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0  && !zeroInArray) {
                zeroInArray = true;
                startZeroIndex = i;
            } else if (num != 0 && zeroInArray) {
                nums[startZeroIndex++] = num;
                nums[i] = 0;
            }
        }
        return nums;
    }

}
