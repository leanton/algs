package me.antonle.stanford.algs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoSumTest {

    @Test
    void should_count_2_sums_correctly() {
        // given
        var twoSum = new TwoSum();
        LongStream.range(-100, 101)
            .forEach(twoSum::add);
        twoSum.finish();

        // expect
        assertTrue(twoSum.hasSumFor(10));
        assertFalse(twoSum.hasSumFor(200));
        assertEquals(100, twoSum.occurredInRange(100, 1000));
    }

    @Test
    void should_calculate_for_dataset() {
        // given
        var ts = new TwoSum();
        ts.add(-3);
        ts.add(-1);
        ts.add(1);
        ts.add(2);
        ts.add(11);
        ts.add(7);
        ts.add(6);
        ts.add(2);
        ts.finish();

        // expect
        assertEquals(8, ts.occurredInRange(3, 11));
    }

    @Test
    @Disabled
    void should_answer_correctly_on_problem_set() throws URISyntaxException, IOException {
        // given
        var twoSum = new TwoSum();
        var scanner = new Scanner(Path.of(getClass().getClassLoader().getResource("2sum.txt").toURI()));
        while (scanner.hasNextLong()) {
            twoSum.add(scanner.nextLong());
        }
        twoSum.finish();

        final Instant start = Instant.now();
        final long occurredInRange = twoSum.occurredInRange(-10_000, 10_001);
        final Instant end = Instant.now();
        System.out.println(Duration.between(start, end)); // PT2M43.761689S
        System.out.println(occurredInRange); // 427
        Assertions.assertEquals(427, occurredInRange);
    }
}