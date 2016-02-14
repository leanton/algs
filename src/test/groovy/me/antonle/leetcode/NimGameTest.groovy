package me.antonle.leetcode

import spock.lang.Specification

class NimGameTest extends Specification {

    def nimGame = new NimGame()

    def "Always lose NimGame example"() {
        given: "When it is 4 stone and your turn you will always lose"
        def n = 4

        expect: "Can not win the game"
        !nimGame.canWinNim(n)

    }

    @SuppressWarnings('all')
    def "Data driven test of nim game"() {
        expect: "Nim game win or loss"
        outcome == nimGame.canWinNim(num)

        where:
        num || outcome
        1   || true
        2   || true
        3   || true
        4   || false
        5   || true
        12  || false
        245 || true

    }
}
