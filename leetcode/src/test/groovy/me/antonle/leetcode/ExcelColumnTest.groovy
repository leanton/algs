package me.antonle.leetcode

import spock.lang.Specification

class ExcelColumnTest extends Specification {

    def excelCol = new ExcelColumn()

    def "Greedy Excel column test"() {
        when:
        def actualOutput = excelCol.titleToNumber(input as String)

        then:
        output == actualOutput

        where:
        input || output
        "A"   || 1
        "AB"  || 28
        "AA"  || 27
        "BA"  || 53


    }
}
