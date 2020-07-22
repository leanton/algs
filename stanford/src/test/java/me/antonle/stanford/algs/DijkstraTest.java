package me.antonle.stanford.algs;

import me.antonle.stanford.algs.Dijkstra.Edge;
import me.antonle.stanford.algs.Dijkstra.Node;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraTest {

    @Test
    void should_calculate_the_shortest_paths_for_simple_graph() {
        // given
        var d = new Dijkstra();
        var s = new Node(1);
        var v = new Node(2);
        var w = new Node(3);
        var t = new Node(4);
        var z = new Node(5);
        s.addEdge(Edge.to(v.id, 1))
            .addEdge(Edge.to(w.id, 4));
        v.addEdge(Edge.to(t.id, 6))
            .addEdge(Edge.to(w.id, 2));
        w.addEdge(Edge.to(t.id, 3));

        d.addNode(s)
            .addNode(v)
            .addNode(w)
            .addNode(t)
            .addNode(z);

        // when
        var distances = d.shortestPathsFor(s, 10_000);

        // then
        assertEquals(1, distances.get(v.id));
        assertEquals(3, distances.get(w.id));
        assertEquals(6, distances.get(t.id));
        assertEquals(10_000, distances.get(z.id));
    }

    @Test
    void should_calculate_shortest_paths() throws URISyntaxException, IOException {
        var scanner = new Scanner(Path.of(getClass().getClassLoader().getResource("dijkstraData.txt").toURI()));
        final Dijkstra d = new Dijkstra();

        while (scanner.hasNextLine()) {
            final String s = scanner.nextLine();
            final String[] splits = s.split("\\t");
            final Node node = new Node(Integer.parseInt(splits[0]));
            for (int i = 1; i < splits.length; i++) {
                final String edgeStr = splits[i];
                final String[] edgeArr = edgeStr.split(",");
                node.addEdge(Edge.to(Integer.parseInt(edgeArr[0]), Integer.parseInt(edgeArr[1])));
            }
            d.addNode(node);
        }

        final Map<Integer, Integer> answers = d.shortestPathsFor(d.getNode(1), 10_000);
        System.out.println(answers);
        // 7,37,59,82,99,115,133,165,188,197
        final String collect = List.of(
            answers.get(7),
            answers.get(37),
            answers.get(59),
            answers.get(82),
            answers.get(99),
            answers.get(115),
            answers.get(133),
            answers.get(165),
            answers.get(188),
            answers.get(197)
        ).stream()
            .map(Object::toString)
            .collect(joining(","));
        System.out.println(collect);
    }
}