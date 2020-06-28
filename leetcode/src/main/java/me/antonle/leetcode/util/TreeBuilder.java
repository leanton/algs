package me.antonle.leetcode.util;

public class TreeBuilder {

    public static TreeNode arrayToTree(Integer[] input) {
        return createTreeNode(input, 1);
    }

    private static TreeNode createTreeNode(Integer[] input, int index) {
        if (index <= input.length) {
            Integer value = input[index - 1];
            if (value != null) {
                TreeNode t = new TreeNode(value);
                t.left = createTreeNode(input, index * 2);
                t.right = createTreeNode(input, index * 2 + 1);
                return t;
            }
        }
        return null;
    }
}
