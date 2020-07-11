package me.antonle.stanford.algs;

import me.antonle.stanford.algs.KargerMinCutGraph.Node;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KargerMinCutGraphTest {

    @Test
    void should_run_min_cut() {
        // given
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(1, Stream.of(2, 3).collect(toList())));
        nodes.add(new Node(2, Stream.of(1, 3, 4).collect(toList())));
        nodes.add(new Node(3, Stream.of(1, 2, 4).collect(toList())));
        nodes.add(new Node(4, Stream.of(2, 3).collect(toList())));
        var minCutGraph = new KargerMinCutGraph(nodes);

        int minCut = Integer.MAX_VALUE;
        for (int j = 0; j < 4; j++) {
            final int x = minCutGraph.copy().minCut();
            minCut = Math.min(x, minCut);
        }
        assertEquals(2, minCut);
    }

    @Test
    void should_run_min_cut_for_big_array() throws URISyntaxException, IOException {
        // given
        var scanner = new Scanner(Path.of(getClass().getClassLoader().getResource("kargerMinCut.txt").toURI()));
        List<Node> nodes = new ArrayList<>();
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            final String[] split = line.split("\t");
            final List<Integer> edges = new ArrayList<>(split.length);
            for (final String s : split) {
                edges.add(Integer.valueOf(s));
            }
            final Integer nodeValue = edges.remove(0);
            nodes.add(new Node(nodeValue, edges));
        }

        // then
        final KargerMinCutGraph minCutGraph = new KargerMinCutGraph(nodes);
        final int iterations = 30;
        for (int i = 1; i < iterations; i++) {
            int minCut = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                final int x = minCutGraph.copy().minCut();
                minCut = Math.min(x, minCut);
            }
            System.out.println(String.format("MIN CUT AFTER %s iterations is: %s", i, minCut));
        }

    }
}