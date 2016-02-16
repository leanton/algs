package me.antonle.leetcode

import spock.lang.Specification

class ValidAnagramTest extends Specification {

    def validAnagram = new ValidAnagram()

    @SuppressWarnings("all")
    def "Valid anagram test"() {
        when:
        def anagram = validAnagram.isAnagram(s1, s2)

        then:
        anagram == answer

        where:

        s1        | s2        || answer
        "asd"     | "das"     || true
        "anagram" | "nagaram" || true
        "rat"     | "car"     || false

    }
}
