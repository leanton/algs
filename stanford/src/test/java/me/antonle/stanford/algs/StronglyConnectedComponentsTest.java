package me.antonle.stanford.algs;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StronglyConnectedComponentsTest {

    @Test
    void should_compute_finish_times_of_the_nodes_correctly() {
        // given
        var scc = new StronglyConnectedComponents();

        scc.addEdge(1, 4)
            .addEdge(4, 7)
            .addEdge(7, 1)
            .addEdge(9, 7)
            .addEdge(9, 3)
            .addEdge(3, 6)
            .addEdge(6, 9)
            .addEdge(8, 6)
            .addEdge(8, 5)
            .addEdge(5, 2)
            .addEdge(2, 8);

        // when
        var ft = scc.computeFinishTimes();

        // then
        System.out.println(ft);
        System.out.println(ft.descendingMap().values());
        assertEquals(3, ft.get(1));
        assertEquals(5, ft.get(2));
        assertEquals(2, ft.get(3));
        assertEquals(8, ft.get(4));
        assertEquals(6, ft.get(5));
        assertEquals(9, ft.get(6));
        assertEquals(1, ft.get(7));
        assertEquals(4, ft.get(8));
        assertEquals(7, ft.get(9));

        var pq = scc.scc();
        System.out.println(pq);
        assertEquals(3, Objects.requireNonNull(pq.poll()).size);
    }

    @Test
    @Disabled
    void should_calculate_fifth_biggest_SCC() throws URISyntaxException, IOException {
        var scc = new StronglyConnectedComponents();
        var scanner = new Scanner(Path.of(getClass().getClassLoader().getResource("scc.txt").toURI()));

        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            final String[] split = line.split(" ");
            final int from = Integer.parseInt(split[0]);
            final int to = Integer.parseInt(split[1]);
            scc.addEdge(from, to);
        }

        final PriorityQueue<StronglyConnectedComponents.SCC> pq = scc.scc();
        for (int i = 0; i < 5; i++) {
            System.out.println(Objects.requireNonNull(pq.poll()).size);
        }
    }
}