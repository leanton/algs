package me.antonle.stanford.algs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KargerMinCutGraph {

    private final List<Node> nodes;

    KargerMinCutGraph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public KargerMinCutGraph copy() {
        final List<Node> copyNodes = new ArrayList<>();
        for (Node node : nodes) {
            copyNodes.add(new Node(node));
        }
        return new KargerMinCutGraph(copyNodes);
    }

    public int minCut() {
        final Random random = new Random();
        while (nodes.size() > 2) {
            final Node node1 = nodes.remove(random.nextInt(nodes.size()));
            final Integer node2Value = node1.edges.get(random.nextInt(node1.edges.size()));
            final Node node2 = nodes.stream().filter(n -> n.value == node2Value).findFirst().orElseThrow();
            nodes.remove(node2);
            contract(node1, node2);
        }
        return nodes.get(0).edges.size();
    }

    private void contract(Node node1, Node node2) {
        Node newNode = merge(node1, node2);
        final int newValue = Math.min(node1.value, node2.value);
        final int oldValue = Math.max(node1.value, node2.value);
        nodes.forEach(node -> replaceNodes(node, newValue, oldValue));
        nodes.add(newNode);
    }

    private void replaceNodes(Node node, Integer newValue, Integer oldValue) {
        int count = 0;
        while (node.edges.remove(oldValue)) {
            count++;
        }
        while (count > 0) {
            node.edges.add(newValue);
            count--;
        }
    }

    private Node merge(Node node1, Node node2) {
        final int newValue = Math.min(node1.value, node2.value);
        final List<Integer> newEdges = Stream.concat(node1.edges.stream(), node2.edges.stream())
            .filter(v -> v != node1.value)
            .filter(v -> v != node2.value)
            .collect(Collectors.toList());
        final Node node = new Node(newValue, newEdges);
        return node;
    }

    static class Node {

        private final int value;
        private final List<Integer> edges;

        public Node(int value, List<Integer> edges) {
            this.value = value;
            this.edges = edges;
        }

        public Node(Node node) {
            this.value = node.value;
            this.edges = new ArrayList<>(node.edges);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "" + value + ":" + edges;
        }
    }

}
