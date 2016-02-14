package me.antonle.leetcode

import spock.lang.Specification

class AddDigitsTest extends Specification {

    def addDigits = new AddDigits()

    def "Add digits data driven test"() {
        expect:
        result == addDigits.addDigits(input)

        where:
        input      || result
        9          || 9
        10         || 1
        11         || 2
        12         || 3
        123        || 6
        1000000001 || 2
        9812       || 2
        192837     || 3
        5511       || 3

    }
}
