package me.antonle.leetcode.medium

import me.antonle.leetcode.util.ListNode
import spock.lang.Specification

class AddTwoNumbersTest extends Specification {

    def solution = new AddTwoNumbers()

    def "should return the sum of two numbers"() {
        given:
        def a = new ListNode(2, new ListNode(4, new ListNode(3)))
        def b = new ListNode(5, new ListNode(6, new ListNode(4)))

        when:
        def sum = solution.addTwoNumbers(a, b)

        then:
        sum.val == 7
        sum.next.val == 0
        sum.next.next.val == 8
    }
}
