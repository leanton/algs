package me.antonle.leetcode.medium

import spock.lang.Specification

class ContainersWithMostWaterTest extends Specification {

    def solution = new ContainersWithMostWater()

    def "should return correct max volume"() {
        expect:
        output == solution.maxArea(input as int[])

        where:
        input                       | output
        [1, 8, 6, 2, 5, 4, 8, 3, 7] | 49
    }
}
