package me.antonle.leetcode.medium

import me.antonle.leetcode.util.ListNode
import spock.lang.Specification

class SwapNodesInPairsTest extends Specification {

    def solution = new SwapNodesInPairs()

    def "should do the right thing"() {
        given:
        def head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))

        when:
        def newHead = solution.swapPairs(head)

        then:
        newHead.val == 2
        newHead.next.val == 1
        newHead.next.next.val == 4
        newHead.next.next.next.val == 3
    }
}
