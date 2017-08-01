package me.antonle.leetcode.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

public class CharCounterJTest {

    @Test
    public void countCharacters() throws Exception {
        final long length = 20_000_000L;
        Iterator<Character> characterIterator = new Iterator<Character>() {
            private long i = 0L;

            @Override
            public boolean hasNext() {
                return i++ < length;
            }

            @Override
            public Character next() {
                return ' ';
            }
        };

        Map<Character, Long> characterLongMap = CharCounter.countCharacters(characterIterator);

        Assert.assertEquals(Long.valueOf(length), characterLongMap.get(' '));
    }

}