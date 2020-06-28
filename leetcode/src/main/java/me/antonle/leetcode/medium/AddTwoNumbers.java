package me.antonle.leetcode.medium;

import me.antonle.leetcode.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, false);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean hasExtraOne) {
        final int extraNumber = hasExtraOne ? 1 : 0;
        if (l1 == null && l2 == null && !hasExtraOne) {
            return null;
        }
        if (l1 == null && l2 == null && hasExtraOne) {
            return new ListNode(extraNumber);
        }
        final var l1Next = l1 == null ? null : l1.next;
        final var l2Next = l2 == null ? null : l2.next;
        final int l1Val = l1 == null ? 0 : l1.val;
        final int l2Val = l2 == null ? 0 : l2.val;
        final int sum = l1Val + l2Val + extraNumber;
        if (sum >= 10) {
            return new ListNode(sum % 10, addTwoNumbers(l1Next, l2Next, true));
        } else {
            return new ListNode(sum, addTwoNumbers(l1Next, l2Next, false));
        }
    }
}
