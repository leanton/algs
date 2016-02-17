package me.antonle.leetcode

import me.antonle.leetcode.util.ListNode
import spock.lang.Specification

class ReverseLinkedListTest extends Specification {

    def reverseLinkedList = new ReverseLinkedList()
    ListNode head

    def "Reverse a linked list simple test"() {
        given:
        head = new ListNode(1)
        head.next = new ListNode(2)
        head.next.next = new ListNode(3)
        head.next.next.next = new ListNode(4)

        when:
        def newHead = reverseLinkedList.reverseList(head)

        then:
        newHead.val == 4
        newHead.next.val == 3
        newHead.next.next.val == 2
        newHead.next.next.next.val == 1

    }
}
