package me.antonle.leetcode.coronachallenge;

import java.util.HashSet;
import java.util.Set;

public class Day_02_HappyNumber {

    public boolean isHappy(int n) {
        final Set<Integer> answers = new HashSet<>();
        while (n != 1) {
            n = sumOfSquares(n);
            if (answers.contains(n)) {
                return false;
            } else {
                answers.add(n);
            }
        }
        return true;
    }

    int sumOfSquares(int number) {
        int answer = 0;
        while (number > 0) {
            int digit = number % 10;
            answer += digit * digit;
            number /= 10;
        }
        return answer;
    }
}
