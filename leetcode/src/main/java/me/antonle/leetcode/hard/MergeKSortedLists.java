package me.antonle.leetcode.hard;

import me.antonle.leetcode.util.ListNode;

public class MergeKSortedLists {

    /**
     * Input:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * <p>
     * Output: 1->1->2->3->4->4->5->6
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode[] newNodes = new ListNode[lists.length / 2 + lists.length % 2];
        for (int i = 0; i < lists.length; i += 2) {
            ListNode l1 = lists[i];
            ListNode l2 = i + 1 >= lists.length ? null : lists[i + 1];
            newNodes[i / 2] = merge(l1, l2);
        }
        return mergeKLists(newNodes);
    }

    /**
     * While loop instead of a recursion
     */
    ListNode merge(ListNode left, ListNode right) {
        final ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        while (left != null || right != null) {
            if (left == null) {
                last.next = right;
                last = last.next;
                right = right.next;
                continue;
            }
            if (right == null) {
                last.next = left;
                last = last.next;
                left = left.next;
                continue;
            }
            if (left.val < right.val) {
                last.next = left;
                last = last.next;
                left = left.next;
            } else {
                last.next = right;
                last = last.next;
                right = right.next;
            }

        }
        return dummy.next;
    }

    /**
     * merge lists recursively
     */
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
        } else {
            return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
        }
    }
}
