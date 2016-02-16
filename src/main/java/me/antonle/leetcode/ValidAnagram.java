package me.antonle.leetcode;

import me.antonle.leetcode.util.Solution;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 */
public class ValidAnagram {

    @Solution
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] fChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        long fSum = sum(fChars);
        long tSum = sum(tChars);
        if (fSum != tSum) {
            return false;
        }
        long fMult = mult(fChars);
        long tMult = mult(tChars);
        return fMult == tMult;
    }

    private long sum(char[] fChars) {
        long sum = 0;
        for (char c : fChars) {
            sum += c;
        }
        return sum;
    }

    private long mult(char[] chars) {
        long mult = 1;
        for (char c : chars) {
            mult *= c;
        }
        return mult;
    }
}
