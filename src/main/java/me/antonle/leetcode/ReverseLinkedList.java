package me.antonle.leetcode;

import me.antonle.leetcode.util.ListNode;
import me.antonle.leetcode.util.Solution;

/**
 * Reverse a singly linked list.
 * */
public class ReverseLinkedList {

    @Solution
    public ListNode reverseList(ListNode head) {
        ListNode reversedPart = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = reversedPart;
            reversedPart = current;
            current = next;
        }
        return reversedPart;
    }
}
