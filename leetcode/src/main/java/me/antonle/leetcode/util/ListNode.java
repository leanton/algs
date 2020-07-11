package me.antonle.leetcode.util;

import java.util.StringJoiner;

/**
 * Used for linked list problems
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
            .add("val=" + val)
            .add("next=" + next)
            .toString();
    }
}
