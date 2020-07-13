package me.antonle.leetcode.medium

import spock.lang.Specification

class MergeIntervalsTest extends Specification {

    def solution = new MergeIntervals()

    def "should do the right thing"() {
        expect:
        output as int[][] == solution.merge(input as int[][])

        where:
        input                               | output
        [[1, 3], [2, 6], [8, 10], [15, 18]] | [[1, 6], [8, 10], [15, 18]]
        [[1, 4], [4, 5]]                    | [[1, 5]]

    }
}
