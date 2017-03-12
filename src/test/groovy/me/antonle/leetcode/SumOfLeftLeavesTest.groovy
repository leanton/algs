package me.antonle.leetcode

import me.antonle.leetcode.util.TreeBuilder
import me.antonle.leetcode.util.TreeNode
import spock.lang.Specification

class SumOfLeftLeavesTest extends Specification {
    private SumOfLeftLeaves solution

    void setup() {
        solution = new SumOfLeftLeaves()
    }

    def "Basic test"() {
        given:
        def root = new TreeNode(10)

        when:
        def sum = solution.sumOfLeftLeaves(root)

        then:
        sum == 0

    }

    def "Solution example"() {
        given:
        def root = new TreeNode(3)
        root.left = new TreeNode(9)
        root.right = new TreeNode(20)
        root.right.left = new TreeNode(15)
        root.right.right = new TreeNode(7)

        when:
        def sum = solution.sumOfLeftLeaves(root)

        then:
        sum == 24

    }

    def "Data driven test"() {
        when:
        def sum = solution.sumOfLeftLeaves(TreeBuilder.arrayToTree(input as Integer[]))

        then:
        sum == expectedSum

        where:
        input                         | expectedSum
        [1, 2, 3]                     | 2
        [3, 9, 20, null, null, 15, 7] | 24
        [1, 2, 3, 4, 5]               | 4

    }
}
