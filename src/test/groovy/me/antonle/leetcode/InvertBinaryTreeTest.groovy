package me.antonle.leetcode

import me.antonle.leetcode.util.TreeNode
import spock.lang.Specification

class InvertBinaryTreeTest extends Specification {
    private InvertBinaryTree invertBinaryTree = new InvertBinaryTree()
    private TreeNode root

    void setup() {
        root = new TreeNode(4)
        root.left = new TreeNode(2)
        root.left.left = new TreeNode(1)
        root.left.right = new TreeNode(3)
        root.right = new TreeNode(7)
        root.right.left = new TreeNode(6)
        root.right.right = new TreeNode(8)
    }

    def "test flipChildren"() {
        when:
        invertBinaryTree.flipChildren(root)
        then:
        root.val == 4
        root.left != null
        root.left.val == 7
        root.right != null
        root.right.val == 2
    }

    def "Binary tree inverts properly"() {
        when:
        invertBinaryTree.invertTree(root)
        then:
        root.val == 4
        root.left.val == 7
        root.left.left.val == 8
        root.left.right.val == 6
        root.right.val == 2
        root.right.left.val == 3
        root.right.right.val == 1

    }
}
