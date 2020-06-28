package me.antonle.leetcode

import spock.lang.Specification

class MajorityElementTest extends Specification {

    def majoriryElement = new MajorityElement()

    @SuppressWarnings("all")
    def "Majority Element data driven test"() {
        when:
        def actual = majoriryElement.majorityElement(input as int[])

        then:
        actual == expected

        where:
        input                                   || expected
        [1, 1, 1, 1, 2, 3, 4]                   || 1
        [2, 3, 4, 4, 4]                         || 4
        [5, 6, 3, 1, 6, 4, 9, 9, 9, 9, 9, 9, 9] || 9

    }
}
