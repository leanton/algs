package me.antonle.leetcode;

import me.antonle.leetcode.util.Solution;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelColumn {

    @Solution
    public int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        final int multiplicator = 26;
        final int offset = 64;
        int col = 0;

        for (int i = 0; i < length; i++) {
            char c = charArray[length - 1 - i];
            int charToNum = c - offset;
            col += pow(multiplicator, i) * charToNum;
        }
        return col;
    }

    private int pow(int multiplicator, int i) {
        if (i == 0) {
            return 1;
        }
        int mult = 1;
        while (i > 0) {
            mult *= multiplicator;
            i--;
        }
        return mult;
    }

}
