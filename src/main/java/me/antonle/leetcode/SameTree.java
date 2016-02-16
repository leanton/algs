package me.antonle.leetcode;


import me.antonle.leetcode.util.Solution;
import me.antonle.leetcode.util.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * <p>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {

    @Solution
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null) && (q == null) || !(p == null || q == null) && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
