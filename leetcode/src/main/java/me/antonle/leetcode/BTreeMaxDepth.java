package me.antonle.leetcode;

import me.antonle.leetcode.util.Solution;
import me.antonle.leetcode.util.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Definition for a binary tree node.
 * {@link me.antonle.leetcode.util.TreeNode}
 */
public class BTreeMaxDepth {

    @Solution
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }

}
