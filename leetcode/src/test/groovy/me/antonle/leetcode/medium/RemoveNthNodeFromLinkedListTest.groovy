package me.antonle.leetcode.medium

import me.antonle.leetcode.util.ListNode
import spock.lang.Specification

class RemoveNthNodeFromLinkedListTest extends Specification {

    def solution = new RemoveNthNodeFromLinkedList()

    def "should do the right thing"() {

        given:
        def head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))

        when:
        solution.removeNthFromEnd(head, 2)

        then:
        head.val == 1
        head.next.val == 2
        head.next.next.val == 3
        head.next.next.next.val == 5
    }
}
