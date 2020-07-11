package me.antonle.leetcode.medium

import spock.lang.Specification

class GenerateParenthesesTest extends Specification {

    def solution = new GenerateParentheses()

    def "should do the right thing"() {
        when:
        def list = solution.generateParenthesis(3)

        then:
        [
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        ].containsAll(list)
    }
}
