package me.antonle.leetcode.medium;

import me.antonle.leetcode.util.ListNode;

public class SwapNodesInPairs {

    /**
     * 1 -> 2 -> 3
     * f -> s -> remaining
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode f = head;
        ListNode s = f != null ? f.next : null;
        ListNode remain = s == null ? null : s.next;

        swap(f, s, prev, remain);
        return dummy.next;
    }

    private void swap(ListNode f, ListNode s, ListNode prev, ListNode remain) {
        if (f == null || s == null) {
            return;
        }
        s.next = f;
        f.next = remain;
        prev.next = s;

        if (remain == null) {
            return;
        }
        swap(remain, remain.next, f, remain.next == null ? null : remain.next.next);
    }

}
