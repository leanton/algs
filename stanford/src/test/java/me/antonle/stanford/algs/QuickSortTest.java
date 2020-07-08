package me.antonle.stanford.algs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSortTest {

    @Test
    void should_sort_the_array() {
        // given
        int[] input = new int[]{4, 5, 7, 6, 3, 1, 2, 8, 8, 6};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 8};

        new QuickSort().quickSort(input);
        Assertions.assertArrayEquals(expected, input);
    }

    @Test
    void should_quicksort() throws URISyntaxException, IOException {
        var scanner = new Scanner(Path.of(getClass().getClassLoader().getResource("quicksort.txt").toURI()));
        var input = new int[10_000];
        int i = 0;
        while (scanner.hasNextInt()) {
            input[i++] = scanner.nextInt();
        }

        final int[] copyInput = Arrays.copyOf(input, 10_000);


        Arrays.sort(copyInput);


        new QuickSort().quickSort(input);
        Assertions.assertArrayEquals(copyInput, input);

    }
}