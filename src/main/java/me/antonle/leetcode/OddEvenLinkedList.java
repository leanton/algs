package me.antonle.leetcode;


import me.antonle.leetcode.util.ListNode;
import me.antonle.leetcode.util.Solution;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {

    @Solution
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prevOdd = head;
        ListNode firstEven = head.next;
        ListNode lastInEven = head.next;
        ListNode nextOdd;
        while (lastInEven != null) {
            nextOdd = lastInEven.next;
            if (nextOdd == null) {
                return head;
            }

            prevOdd.next = nextOdd;
            lastInEven.next = nextOdd.next;
            nextOdd.next = firstEven;

            prevOdd = nextOdd;
            lastInEven = lastInEven.next;
        }
        return head;
    }
}
