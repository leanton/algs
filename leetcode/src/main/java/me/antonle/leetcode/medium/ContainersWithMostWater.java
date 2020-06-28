package me.antonle.leetcode.medium;

public class ContainersWithMostWater {

    /**
     * Time complexity -> O(N^2) algorithm
     * Space complexity -> O(1) ?
     */
    public int maxArea(int[] height) {
        return optimizedSolution(height);
    }

    /**
     * Time complexity -> O(N^2) algorithm
     * Space complexity -> O(1) ?
     */
    private int greedySolution(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                final int length = j - i;
                final int minH = Math.min(height[i], height[j]);
                final int area = length * minH;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    /**
     * [1, 8, 6, 2, 5, 4, 8, 3, 7]
     * 2 pointers to iterate over the array
     * 1st pointer i starts from element height[0]
     * 2nd pointer j starts from element height[n-1]
     */
    public int optimizedSolution(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

}
