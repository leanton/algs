package me.antonle.leetcode;


import me.antonle.leetcode.util.Solution;
import me.antonle.leetcode.util.TreeNode;

/**
 * Invert a binary tree.
 * Example:
 *        4
 *      /   \
 *     2     7
 *    / \   / \
 *   1   3 6   9
 *
 * to
 *
 *        4
 *      /   \
 *     7     2
 *    / \   / \
 *   9   6 3   1
 *
 * Used TreeNode
 * {@link me.antonle.leetcode.util.TreeNode}
 * */
public class InvertBinaryTree {

    @Solution
    public TreeNode invertTree(TreeNode root) {
        // TODO
        return root;
    }

    void flipChildren(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
