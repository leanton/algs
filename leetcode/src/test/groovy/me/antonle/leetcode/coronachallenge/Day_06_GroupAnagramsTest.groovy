package me.antonle.leetcode.coronachallenge

import spock.lang.Specification

class Day_06_GroupAnagramsTest extends Specification {

    def challenge = new Day_06_GroupAnagrams()

    def "should group anagrams"() {
        given:
        def input = ["eat", "tea", "tan", "ate", "nat", "bat"]

        when:
        def anagrams = challenge.groupAnagrams(input as String[])

        then:
        anagrams.sort() == [
                ["eat", "tea", "ate"],
                ["tan", "nat"],
                ["bat"]
        ].sort()

    }
}
