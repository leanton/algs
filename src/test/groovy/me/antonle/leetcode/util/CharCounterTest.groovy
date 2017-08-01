package me.antonle.leetcode.util

import spock.lang.Specification

class CharCounterTest extends Specification {

    def "Counting characters"() {
        expect:
        countCharacters == CharCounter.countCharacters(text)

        where:
        text   || countCharacters
        "tree" || [('t' as char): 1, ('e' as char): 2, ('r' as char): 1]
        null   || [:]
        ""     || [:]


    }

    def "Counting characters from iterator"() {
        expect:
        countCharacters == CharCounter.countCharacters(text.toCharArray().iterator())

        where:
        text   || countCharacters
        "tree" || [('t' as char): 1, ('e' as char): 2, ('r' as char): 1]
        ""     || [:]
    }


}
