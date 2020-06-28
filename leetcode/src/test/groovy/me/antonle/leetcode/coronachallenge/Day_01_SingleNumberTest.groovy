package me.antonle.leetcode.coronachallenge

import spock.lang.Specification

class Day_01_SingleNumberTest extends Specification {

    def challenge = new Day_01_SingleNumber()

    def "should return single number"() {
        expect:
        expected == challenge.singleNumber(array as int[])

        where:
        array           | expected
        [2, 2, 1]       | 1
        [4, 1, 2, 1, 2] | 4
        [1]             | 1

    }

    def "should throw if empty array or null"() {
        when:
        challenge.singleNumber(arg)

        then:
        thrown(IllegalArgumentException)

        where:
        arg << [null, [] as int[]]
    }
}
