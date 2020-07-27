package me.antonle.stanford.algs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

public class TwoSum {

    private final Map<Long, Integer> numsCounter;
    private final List<Long> nums;

    public TwoSum() {
        this.numsCounter = new HashMap<>();
        this.nums = new ArrayList<>();
    }

    public void add(long i) {
        nums.add(i);
        numsCounter.put(i, numsCounter.getOrDefault(i, 0) + 1);
    }

    public void finish() {
        nums.sort(Long::compareTo);
    }

    public boolean hasSumFor(long target) {
        for (Long num : nums) {
            if (num > target) {
                return false;
            }
            long remain = target - num;
            if (remain != num && numsCounter.containsKey(remain)) {
                return true;
            }
        }
        return false;
    }

    public long occurredInRange(long startTarget, long endTargetExclusive) {
        return LongStream.range(startTarget, endTargetExclusive)
            .parallel()
            .mapToObj(this::hasSumFor)
            .filter(b -> b)
            .count();
    }
}
