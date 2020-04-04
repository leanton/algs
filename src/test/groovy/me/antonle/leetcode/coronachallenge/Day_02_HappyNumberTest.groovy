package me.antonle.leetcode.coronachallenge

import spock.lang.Specification

class Day_02_HappyNumberTest extends Specification {

    def challenge = new Day_02_HappyNumber()

    def "should calculate whether the number is happy or not"() {
        expect:
        isHappy == challenge.isHappy(number as int)

        where:
        number || isHappy
        19     || true
        1000   || true
        21     || false
    }

    def "should calculate sum of squares of digits of a number"() {
        expect:
        expectedAnswer == challenge.sumOfSquares(number as int)

        where:
        number || expectedAnswer
        19     || 82
        1000   || 1
        21     || 5
    }
}
