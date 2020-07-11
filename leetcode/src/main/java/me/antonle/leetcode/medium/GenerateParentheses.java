package me.antonle.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private final List<String> parenthesis = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        final char[] chars = new char[2 * n];
        generate(chars, 0, n, n);
        return parenthesis;
    }

    public void generate(char[] arr, int index, int remainOpen, int remainClose) {
        if (remainOpen == 0 && remainClose == 0) {
            this.parenthesis.add(String.copyValueOf(arr));
            return;
        }
        if (remainOpen >= remainClose) {
            arr[index] = '(';
            generate(arr, index + 1, remainOpen - 1, remainClose);
        } else if (remainOpen == 0) {
            arr[index] = ')';
            generate(arr, index + 1, remainOpen, remainClose - 1);
        } else {
            arr[index] = '(';
            generate(arr, index + 1, remainOpen - 1, remainClose);

            arr[index] = ')';
            generate(arr, index + 1, remainOpen, remainClose - 1);
        }
    }

}
