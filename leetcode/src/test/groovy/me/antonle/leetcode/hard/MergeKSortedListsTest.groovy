package me.antonle.leetcode.hard

import me.antonle.leetcode.util.ListNode
import spock.lang.Specification

class MergeKSortedListsTest extends Specification {

    def solution = new MergeKSortedLists()

    def "should do the merge correctly"() {
        given:
        def left = new ListNode(1, new ListNode(3, new ListNode(4)))
        def right = new ListNode(2, new ListNode(6))

        when:
        def head = solution.mergeTwoLists(left, right)

        then:
        head.val == 1
        head.next.val == 2
        head.next.next.val == 3
        head.next.next.next.val == 4
        head.next.next.next.next.val == 6
        head.next.next.next.next.next == null

    }
}
