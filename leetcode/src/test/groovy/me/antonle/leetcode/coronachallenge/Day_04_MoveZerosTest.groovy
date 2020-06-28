package me.antonle.leetcode.coronachallenge

import spock.lang.Specification

class Day_04_MoveZerosTest extends Specification {

    def challenge = new Day_04_MoveZeros()

    def "should move zeros to the bottom of the array and return the new array"() {
        expect:
        def actual = challenge.moveZeroesWithReturn(input as int[])
        expected as int[] == actual

        where:
        input            | expected
        [0, 1, 0, 3, 12] | [1, 3, 12, 0, 0]
        [0, 0, 0]        | [0, 0, 0]
        [0, 1, 2, 3]     | [1, 2, 3, 0]
    }

    def "should move zeros to the bottom of the array"() {
        expect:
        def actual = input as int[]
        challenge.moveZeroes(actual)
        expected as int[] == actual

        where:
        input            | expected
        [0, 1, 0, 3, 12] | [1, 3, 12, 0, 0]
        [0, 0, 0]        | [0, 0, 0]
        [0, 1, 2, 3]     | [1, 2, 3, 0]
    }
}
