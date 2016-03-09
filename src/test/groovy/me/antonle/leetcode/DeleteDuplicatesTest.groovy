package me.antonle.leetcode

import me.antonle.leetcode.util.ListNode
import spock.lang.Specification

class DeleteDuplicatesTest extends Specification {

    def deleteDuplicates = new DeleteDuplicates()
    ListNode root

    def "Delete duplicates test as in example 1"() {
        given:
        root = new ListNode(1)
        root.next = new ListNode(1)
        root.next.next = new ListNode(2)

        when:
        def newRoot = deleteDuplicates.deleteDuplicates(root)

        then:
        newRoot.val == 1
        newRoot.next.val == 2
        newRoot.next.next == null


    }

    def "Delete duplicates test as in example 2"() {
        given:
        root = new ListNode(1)
        root.next = new ListNode(1)
        root.next.next = new ListNode(2)
        root.next.next.next = new ListNode(3)
        root.next.next.next.next = new ListNode(3)

        when:
        def newRoot = deleteDuplicates.deleteDuplicates(root)

        then:
        newRoot.val == 1
        newRoot.next.val == 2
        newRoot.next.next.val == 3
        newRoot.next.next.next == null


    }

    def "Null head test"() {
        when:
        def newRoot = deleteDuplicates.deleteDuplicates(root)

        then:
        newRoot == null
    }
}
