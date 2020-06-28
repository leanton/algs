package me.antonle.leetcode

import me.antonle.leetcode.util.TreeNode
import spock.lang.Specification

class BTreeMaxDepthTest extends Specification {

    private BTreeMaxDepth maxDepth = new BTreeMaxDepth()

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

    def "B-tree simple max depth"() {
        expect:
        maxDepth.maxDepth(root) == 3
    }

    def "B-tree tricky max depth"() {
        when:
        root.right.right.right = new TreeNode(10)
        root.right.right.right.right = new TreeNode(11)
        root.right.right.right.right.right = new TreeNode(12)

        then:
        maxDepth.maxDepth(root) == 6

    }
}
