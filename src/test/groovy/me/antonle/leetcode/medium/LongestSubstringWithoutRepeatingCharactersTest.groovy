package me.antonle.leetcode.medium

import spock.lang.Specification

class LongestSubstringWithoutRepeatingCharactersTest extends Specification {

    def solution = new LongestSubstringWithoutRepeatingCharacters()

    def "should find the longest substring"() {
        expect:
        expected == solution.lengthOfLongestSubstring(input)

        where:
        input      | expected
        "abcabcbb" | 3
        "bbbbb"    | 1
        "pwwkew"   | 3
    }
}
