package me.antonle.leetcode

import me.antonle.leetcode.util.ListNode
import spock.lang.Specification

class DeleteNodeInLinkedListTest extends Specification {

    def deleteNode = new DeleteNodeInLinkedList()
    ListNode rootNode

    void setup() {
        rootNode = new ListNode(1)
        rootNode.next = new ListNode(2)
        rootNode.next.next = new ListNode(3)
        rootNode.next.next.next = new ListNode(4)
    }

    def "Delete node simple example (equality by value)"() {
        given:
        ListNode toDelete = rootNode.next.next

        when:
        deleteNode.deleteNode(toDelete)

        then:
        rootNode.val == 1
        rootNode.next.val == 2
        rootNode.next.next.val == 4
    }

    def "Delete node simple example (NO equality by reference)"() {
        given:
        ListNode toDelete = rootNode.next.next
        def nextNode = toDelete.next

        when:
        deleteNode.deleteNode(toDelete)

        then:
        rootNode.next.next != nextNode // !!!!!!
    }
}
