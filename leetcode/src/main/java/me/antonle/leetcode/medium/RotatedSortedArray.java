package me.antonle.leetcode.medium;

public class RotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            final int midValue = nums[mid];
            if (midValue == target) return mid;
            if (midValue >= nums[left]) {
                if (target < midValue && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > midValue) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
