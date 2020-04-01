package me.antonle.leetcode.coronachallenge;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Day_01_SingleNumber {

    public int singleNumber(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        return new Deduplicator(nums).getSingleElement();
    }

    private static class Deduplicator {

        private final Set<Integer> set;

        private Deduplicator(int[] nums) {

            this.set = new HashSet<>();
            for (final int num : nums) {
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            }
        }

        public int getSingleElement() {
            assert set.size() == 1;
            return set.iterator().next();
        }
    }

}
