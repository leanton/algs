package me.antonle.leetcode.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetEquals {

    @Test
    public void testEqualsHashSet() {
        HashSet<String> setA = new HashSet<>(Arrays.asList("A", "B", "C"));
        HashSet<String> setB = new HashSet<>(Arrays.asList("B", "A", "C"));


        Assert.assertEquals(setA, setB);
    }
}
