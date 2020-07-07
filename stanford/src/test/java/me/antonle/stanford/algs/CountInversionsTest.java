package me.antonle.stanford.algs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class CountInversionsTest {

    @Test
    public void should_count_inversions() {
        // given
        int[] input = new int[]{1, 4, 3, 5, 2, 6};

        // when
        var inversions = CountInversionsBruteForce.countInversionsBF(input);
        final long countInversions = new CountInversionsViaMergeSort().countInversions(input);
        Assertions.assertEquals(4L, countInversions);
    }

    @Test
    public void should_count_inversions_from_file() throws IOException {
        var scanner = new Scanner(Path.of("/Users/anton.le/Developer/edu/algs/stanford/src/test/resources/inversions.txt"));
        var input = new int[100_000];
        int i = 0;
        while (scanner.hasNextInt()) {
            input[i++] = scanner.nextInt();
        }

        Instant start1 = Instant.now();
        final long inversions = new CountInversionsViaMergeSort().countInversions(input);
        Instant end1 = Instant.now();

        Instant startBF = Instant.now();
        final long inversionsBF = CountInversionsBruteForce.countInversionsBF(input);
        Instant endBF = Instant.now();

        System.out.println(Duration.between(start1, end1));
        System.out.println(Duration.between(startBF, endBF));
        System.out.println(inversions);
        Assertions.assertEquals(inversionsBF, inversions);
    }
}