package me.antonle.leetcode;

import me.antonle.leetcode.util.Solution;
import me.antonle.leetcode.util.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

    @Solution
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
