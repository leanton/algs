package me.antonle.stanford.algs;

import java.util.*;

public class Dijkstra {

    private final Map<Integer, Node> nodes;

    public Dijkstra() {
        this.nodes = new HashMap<>();
    }

    public Dijkstra addNode(Node node) {
        this.nodes.put(node.id, node);
        return this;
    }

    public Node getNode(int id) {
        return this.nodes.get(id);
    }

    public Map<Integer, Integer> shortestPathsFor(Node node, int defaultUnreachableLength) {
        return new DijkstraAlg(node, defaultUnreachableLength).compute();
    }

    private class DijkstraAlg {

        private final Set<Node> frontier;
        private final Map<Integer, Integer> shortestDistances;
        private final int defaultUnreachableLength;

        public DijkstraAlg(Node node, int defaultUnreachableLength) {
            this.frontier = new HashSet<>();
            this.shortestDistances = new HashMap<>();
            this.frontier.add(node);
            this.shortestDistances.put(node.id, 0);
            this.defaultUnreachableLength = defaultUnreachableLength;
        }

        public Map<Integer, Integer> compute() {
            while (nodes.size() > frontier.size()) {
                Node nextNode = null;
                int minLen = Integer.MAX_VALUE;
                for (Node node : frontier) {
                    for (final Edge edge : node.edges) {
                        if (shortestDistances.containsKey(edge.destNode)) {
                            continue;
                        }

                        if (shortestDistances.get(node.id) + edge.length < minLen) {
                            minLen = shortestDistances.get(node.id) + edge.length;
                            nextNode = nodes.get(edge.destNode);
                        }
                    }
                }
                if (Objects.isNull(nextNode)) {
                    nodes.values().stream()
                        .filter(n -> !frontier.contains(n))
                        .forEach(n -> shortestDistances.put(n.id, this.defaultUnreachableLength));
                    return shortestDistances;
                }
                final Node nonNull = Objects.requireNonNull(nextNode);
                shortestDistances.put(nonNull.id, minLen);
                frontier.add(nonNull);
            }

            return shortestDistances;
        }
    }

    static class Node {

        public final int id;
        private final Set<Edge> edges;

        public Node(int id) {
            this.id = id;
            this.edges = new HashSet<>();
        }

        public Node addEdge(Edge edge) {
            edges.add(edge);
            return this;
        }

    }

    static class Edge {

        public final int destNode;
        public final int length;

        public static Edge to(int destNode, int length) {
            return new Edge(destNode, length);
        }

        Edge(int destNode, int length) {
            this.destNode = destNode;
            this.length = length;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Edge edge = (Edge) o;
            return destNode == edge.destNode &&
                length == edge.length;
        }

        @Override
        public int hashCode() {
            return Objects.hash(destNode, length);
        }

    }
}
