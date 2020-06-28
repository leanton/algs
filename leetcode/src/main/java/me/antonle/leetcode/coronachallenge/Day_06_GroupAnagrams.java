package me.antonle.leetcode.coronachallenge;

import java.util.*;

public class Day_06_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> groupedAnagrams = new HashMap<>();
        for (final String str : strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);
            final String key = new String(chars);
            final List<String> anagrams = groupedAnagrams.getOrDefault(key, new ArrayList<>(1));
            anagrams.add(str);
            groupedAnagrams.put(key, anagrams);
        }

        return new ArrayList<>(groupedAnagrams.values());
    }

}
