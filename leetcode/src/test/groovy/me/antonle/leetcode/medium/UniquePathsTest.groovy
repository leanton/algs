package me.antonle.leetcode.medium

import spock.lang.Specification

class UniquePathsTest extends Specification {

    def solution = new UniquePaths()

    def "should do the right thing"() {
        expect:
        out == solution.uniquePaths(m, n)

        where:
        m | n || out
        1 | 1 || 1
        1 | 2 || 1
        2 | 2 || 2
        2 | 3 || 3
        3 | 2 || 3
    }
}
