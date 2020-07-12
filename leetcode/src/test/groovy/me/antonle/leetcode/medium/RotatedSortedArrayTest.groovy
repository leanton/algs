package me.antonle.leetcode.medium

import spock.lang.Specification

class RotatedSortedArrayTest extends Specification {

    def solution = new RotatedSortedArray()

    def "should do the right thing"() {
        expect:
        res == solution.search([4, 5, 6, 7, -1, 0, 1, 2] as int[], target);

        where:
        target | res
        4      | 0
        5      | 1
        6      | 2
        7      | 3
        -1     | 4
        0      | 5
        1      | 6
        2      | 7
        3      | -1
    }

    def "should do the right thing 2"() {
        expect:
        res == solution.search([7, 8, 1, 2, 3, 4, 5, 6] as int[], target);

        where:
        target | res
        7      | 0
        8      | 1
        1      | 2
        2      | 3
        3      | 4
        4      | 5
        5      | 6
        6      | 7
    }
}
