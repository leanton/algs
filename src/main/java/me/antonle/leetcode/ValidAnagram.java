package me.antonle.leetcode;

import me.antonle.leetcode.util.Solution;

import java.util.List;
import java.util.stream.Collectors;

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
        char[] sChars = s.toCharArray();
        List<Character> tList = t.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        for (char sChar : sChars) {
            if (!tList.remove(Character.valueOf(sChar))) {
                return false;
            }
        }
        return true;
    }
}
