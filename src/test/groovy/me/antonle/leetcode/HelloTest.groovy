package me.antonle.leetcode

import spock.lang.Specification

class HelloTest extends Specification {

    def "This is a simple test"() {
        given: "A person's name is given as a method parameter."
        def greeting = "hello"

        expect: "Should say hello to the person whose name is given as a method parameter"
        greeting == "hello";

    }
}
