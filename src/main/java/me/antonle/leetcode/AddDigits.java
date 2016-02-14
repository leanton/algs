package me.antonle.leetcode;

import me.antonle.leetcode.util.Solution;


/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * */
public class AddDigits {

    @Solution
    public int addDigits(int num) {
        while (num >= 10) {
            num = splitAndSum(num);
        }
        return num;
    }

    private int[] splitNumber(int num) {
        int[] ints = new int[String.valueOf(num).length()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = num % 10;
            num /= 10;
        }
        return ints;
    }

    private int splitAndSum(int num) {
        int[] ints = splitNumber(num);
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }
        return sum;
    }

}
