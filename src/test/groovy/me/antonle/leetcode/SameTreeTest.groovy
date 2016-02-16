package me.antonle.leetcode

import me.antonle.leetcode.util.TreeNode
import spock.lang.Specification

class SameTreeTest extends Specification {

    def sameTree = new SameTree()

    def "Simple trees equality"() {
        given:
        def root1 = new TreeNode(1)
        def root2 = new TreeNode(1)

        root1.left = new TreeNode(2)
        root1.right = new TreeNode(3)
        root1.left.left = new TreeNode(4)
        root1.left.left.right = new TreeNode(5)

        root2.left = new TreeNode(2)
        root2.right = new TreeNode(3)
        root2.left.left = new TreeNode(4)
        root2.left.left.right = new TreeNode(5)

        when:
        def isSameTree = sameTree.isSameTree(root1, root2)

        then:
        isSameTree

    }

    def "Simple trees inequality"() {
        given:
        def root1 = new TreeNode(1)
        def root2 = new TreeNode(1)

        root1.left = new TreeNode(2)
        root1.right = new TreeNode(3)
        root1.left.left = new TreeNode(4)
        root1.left.left.right = new TreeNode(5)

        root2.left = new TreeNode(2)
        root2.right = new TreeNode(3)
        root2.left.left = new TreeNode(4)
        root2.left.left.right = new TreeNode(5)
        root2.right.left = new TreeNode(6)

        when:
        def isSameTree = sameTree.isSameTree(root1, root2)

        then:
        !isSameTree

    }
}
