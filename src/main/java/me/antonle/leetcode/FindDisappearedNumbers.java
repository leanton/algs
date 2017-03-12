package me.antonle.leetcode;

import me.antonle.leetcode.util.Solution;

import java.util.ArrayList;
import java.util.List;


/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 */
public class FindDisappearedNumbers {

    @Solution
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] list = new int[nums.length]; // extra space needed for this solution
        for (int num : nums) {
            list[num - 1]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
