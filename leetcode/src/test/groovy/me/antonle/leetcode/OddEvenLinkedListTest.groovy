package me.antonle.leetcode

import me.antonle.leetcode.util.ListNode
import spock.lang.Specification

class OddEvenLinkedListTest extends Specification {

    def linkedList = new OddEvenLinkedList()
    private ListNode root

    def "Simple linked list test as in example"() {
        given:
        root = new ListNode(1)
        root.next = new ListNode(2)
        root.next.next = new ListNode(3)
        root.next.next.next = new ListNode(4)
        root.next.next.next.next = new ListNode(5)

        when:
        def newRoot = linkedList.oddEvenList(root)

        then:
        newRoot.val == 1
        newRoot.next.val == 3
        newRoot.next.next.val == 5
        newRoot.next.next.next.val == 2
        newRoot.next.next.next.next.val == 4

    }

    def "Simple linked list test with even length"() {
        given:
        root = new ListNode(1)
        root.next = new ListNode(2)
        root.next.next = new ListNode(3)
        root.next.next.next = new ListNode(4)
        root.next.next.next.next = new ListNode(5)
        root.next.next.next.next.next = new ListNode(6)

        when:
        def newRoot = linkedList.oddEvenList(root)

        then:
        newRoot.val == 1
        newRoot.next.val == 3
        newRoot.next.next.val == 5
        newRoot.next.next.next.val == 2
        newRoot.next.next.next.next.val == 4
        newRoot.next.next.next.next.next.val == 6

    }

    def "Small linked list"() {
        given:
        root = new ListNode(1)
        root.next = new ListNode(2)
        root.next.next = new ListNode(3)

        when:
        def newRoot = linkedList.oddEvenList(root)

        then:
        newRoot.val == 1
        newRoot.next.val == 3
        newRoot.next.next.val == 2
    }

    def "Small linked list 2"() {
        given:
        root = new ListNode(1)
        root.next = new ListNode(2)

        when:
        def newRoot = linkedList.oddEvenList(root)

        then:
        newRoot.val == 1
        newRoot.next.val == 2
    }

    def "Small linked list 3"() {
        given:
        root = new ListNode(1)

        when:
        def newRoot = linkedList.oddEvenList(root)

        then:
        newRoot.val == 1
    }

    def "Small linked list 4"() {
        given:
        root = null

        when:
        def newRoot = linkedList.oddEvenList(root)

        then:
        newRoot == null
    }
}
