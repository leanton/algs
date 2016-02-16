package me.antonle.leetcode

import spock.lang.Specification

class MoveZerosTest extends Specification {

    def moveZeros = new MoveZeros()

    def "Move zeros data driven test"() {
        given:
        def actualOutput = moveZeros.moveZeroes(input as int[])

        expect:
        actualOutput == output

        where:
        input            || output
        [1, 2, 3]        || [1, 2, 3]
        [0, 0]           || [0, 0]
        [0, 1, 0]        || [1, 0, 0]
        [0, 1, 0, 3, 12] || [1, 3, 12, 0, 0]

    }
}
