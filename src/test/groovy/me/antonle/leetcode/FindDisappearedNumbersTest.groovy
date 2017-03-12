package me.antonle.leetcode

import spock.lang.Specification

class FindDisappearedNumbersTest extends Specification {
    private numbers = new FindDisappearedNumbers()

    void setup() {

    }

    def "Data driven test"() {
        when:
        def result = numbers.findDisappearedNumbers(nums as int[])

        then:
        result == expectedResult

        where:
        nums                     | expectedResult
        [4, 3, 2, 7, 8, 2, 3, 1] | [5, 6]
        [1, 2, 4, 2]             | [3]
        [5, 4, 3, 2, 1]          | []
    }
}
