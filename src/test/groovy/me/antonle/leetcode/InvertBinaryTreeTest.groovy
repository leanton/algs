package me.antonle.leetcode

import me.antonle.leetcode.util.TreeNode
import spock.lang.Specification

class InvertBinaryTreeTest extends Specification {
    private InvertBinaryTree invertBinaryTree = new InvertBinaryTree()


    def "test flipChildren"() {
        given:
        def root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.right = new TreeNode(3)

        when:
        invertBinaryTree.flipChildren(root)
        then:
        root.val == 1
        root.left != null
        root.left.val == 3
        root.right != null
        root.right.val == 2
    }
}
