package me.antonle.leetcode;

import me.antonle.leetcode.util.Solution;
import me.antonle.leetcode.util.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {

    @Solution
    public int sumOfLeftLeaves(TreeNode root) {
        return addLeftTree(root);
    }

    private int addLeftTree(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null) {
            return addLeftTree(node.right);
        } else if (node.left.left == null && node.left.right == null) {
            return node.left.val + addLeftTree(node.right);
        } else {
            return addLeftTree(node.left) + addLeftTree(node.right);
        }
    }
}
