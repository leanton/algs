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
            num = sumNumber(num);
        }
        return num;
    }

    private int sumNumber(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
