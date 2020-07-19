package me.antonle.stanford.algs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapMedianTest {

    private HeapMedian heapMedian;

    @BeforeEach
    void setUp() {
        this.heapMedian = new HeapMedian();
    }

    @Test
    void should_do_the_right_thing() {
        // when
        Stream.of(20, 15, 11, 43, 10, 17).forEach(i -> heapMedian.add(i));

        // then
        assertEquals(15, heapMedian.median());
    }

    @Test
    void should_calculate_the_median_from_big_file() throws URISyntaxException, IOException {
        // given
        var scanner = new Scanner(Path.of(getClass().getClassLoader().getResource("heapMedian.txt").toURI()));
        List<Integer> vals = new ArrayList<>();

        // when
        while (scanner.hasNextInt()) {
            final int elem = scanner.nextInt();
            vals.add(elem);
            heapMedian.add(elem);
        }

        Collections.sort(vals);

        // then
        Assertions.assertEquals(vals.get((vals.size() - 1) / 2), heapMedian.median());
    }

    @Test
    void should_calculate_the_sum_of_medians() throws URISyntaxException, IOException {
        // given
        var scanner = new Scanner(Path.of(getClass().getClassLoader().getResource("heapMedian.txt").toURI()));
        long sum = 0;
        while (scanner.hasNextInt()) {
            final int elem = scanner.nextInt();
            heapMedian.add(elem);
            sum += heapMedian.median();
        }

        // then
        System.out.println(sum % 10000);
    }
}