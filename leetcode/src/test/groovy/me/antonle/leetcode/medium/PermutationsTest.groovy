package me.antonle.leetcode.medium

import spock.lang.Specification

class PermutationsTest extends Specification {

    def solution = new Permutations()

    def "should do the right thing"() {
        given:
        def input = [1, 2, 3] as int[]

        when:
        def lists = solution.permute(input)

        then:
        [
                [1,2,3],
                [1,3,2],
                [2,1,3],
                [2,3,1],
                [3,1,2],
                [3,2,1]
        ] == lists

    }
}
