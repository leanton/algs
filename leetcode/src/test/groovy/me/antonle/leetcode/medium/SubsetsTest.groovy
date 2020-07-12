package me.antonle.leetcode.medium

import spock.lang.Specification

class SubsetsTest extends Specification {

    def solution = new Subsets()

    def "should return all possible subsets"() {
        when:
        def res = solution.subsets([1, 2, 3] as int[])

        then:
        [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]] == res
    }
}
