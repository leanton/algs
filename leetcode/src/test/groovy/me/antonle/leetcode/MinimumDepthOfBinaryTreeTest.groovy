package me.antonle.leetcode

import me.antonle.leetcode.util.TreeBuilder
import spock.lang.Specification

class MinimumDepthOfBinaryTreeTest extends Specification {
    private MinimumDepthOfBinaryTree solution

    void setup() {
        solution = new MinimumDepthOfBinaryTree()
    }

    def "Data driven test"() {
        when:
        def actualResult = solution.minDepth(TreeBuilder.arrayToTree(input as Integer[]))

        then:
        actualResult == expectedResult

        where:
        input     | expectedResult
        [null]    | 0
        [1, 2, 3] | 2
        [1, 2]    | 2
        [3, 9, 20, null, null, 15, 7] | 2

    }
}
