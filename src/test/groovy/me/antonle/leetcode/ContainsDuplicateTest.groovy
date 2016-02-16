package me.antonle.leetcode

import spock.lang.Specification

class ContainsDuplicateTest extends Specification {

    def duplicates = new ContainsDuplicate()

    @SuppressWarnings("all")
    def "Contains duplicate test"() {
        when:
        def hasDups = duplicates.containsDuplicate(input as int[])

        then:
        hasDups == answer

        where:
        input                    || answer
        [1, 2, 3]                || false
        [0, 0, 1]                || true
        [1, 2, 3, 4, 5, 6, 7, 3] || true

    }
}
