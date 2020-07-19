package me.antonle.stanford.algs;

import java.util.*;
import java.util.stream.Collectors;

public class StronglyConnectedComponents {

    final TreeMap<Integer, Node> nodes;

    public StronglyConnectedComponents() {
        this.nodes = new TreeMap<>();
    }

    public StronglyConnectedComponents addEdge(int from, int to) {
        if (from == to) {
            return this;
        }
        final Node fromNode = getOrElseCreate(from);
        final Node toNode = getOrElseCreate(to);
        fromNode.addOutgoing(toNode);
        toNode.addIncoming(fromNode);
        return this;
    }

    private Node getOrElseCreate(int value) {
        if (nodes.containsKey(value)) {
            return nodes.get(value);
        } else {
            final Node newNode = new Node(value);
            nodes.put(value, newNode);
            return newNode;
        }
    }

    public TreeMap<Integer, Integer> computeFinishTimes() {
        return new FinishTimeComputer().compute();
    }

    public PriorityQueue<SCC> scc() {
        final TreeMap<Integer, Integer> ft = computeFinishTimes();
        final Collection<Integer> nodesToIterate = ft.descendingMap().values();
        return new SccCalculator(nodesToIterate).calculate();
    }

    @Override
    public String toString() {
        return nodes.values().stream().map(Node::toString).collect(Collectors.joining("\n"));
    }

    public static class Node {

        public final Integer value;
        private final Set<Node> outgoingNodes;
        private final Set<Node> incomingNodes;

        public Node(int value) {
            this.value = value;
            this.outgoingNodes = new HashSet<>();
            this.incomingNodes = new HashSet<>();
        }

        public boolean addOutgoing(Node node) {
            return this.outgoingNodes.add(node);
        }

        public boolean addIncoming(Node node) {
            return this.incomingNodes.add(node);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Node node = (Node) o;
            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", this.value + "[", "]")
                .add("out=" + outgoingNodes.stream().map(n -> n.value.toString()).collect(Collectors.joining(",")))
                .add("in=" + incomingNodes.stream().map(n -> n.value.toString()).collect(Collectors.joining(",")))
                .toString();
        }
    }

    private class FinishTimeComputer {

        private final TreeMap<Integer, Integer> finishTimes;
        private final Set<Node> exploredNodes;
        private int finishTime;

        public FinishTimeComputer() {
            this.finishTimes = new TreeMap<>();
            this.exploredNodes = new HashSet<>();
            this.finishTime = 1;
        }

        public TreeMap<Integer, Integer> compute() {
            for (final Node node : nodes.descendingMap().values()) {
                if (!exploredNodes.contains(node)) {
                    dfs(node);
                }
            }
            return finishTimes;
        }

        private void dfs(Node entry) {
            exploredNodes.add(entry);
            for (final Node incomingNode : entry.incomingNodes) {
                if (!exploredNodes.contains(incomingNode)) {
                    dfs(incomingNode);
                }
            }
            finishTimes.put(finishTime++, entry.value);
        }
    }

    private class SccCalculator {

        private final Collection<Integer> nodesToIterate;
        private final Set<Node> exploredNodes;
        private int size;

        public SccCalculator(Collection<Integer> nodesToIterate) {
            this.nodesToIterate = nodesToIterate;
            this.exploredNodes = new HashSet<>();
        }

        public PriorityQueue<SCC> calculate() {
            final PriorityQueue<SCC> sccs = new PriorityQueue<>();
            for (final Integer nodeValue : nodesToIterate) {
                final Node node = nodes.get(nodeValue);
                size = 1;
                dfs(node);
                if (size > 1) {
                    sccs.add(new SCC(size, node));
                }
            }
            return sccs;
        }

        private void dfs(Node entry) {
            exploredNodes.add(entry);
            for (final Node outNode : entry.outgoingNodes) {
                if (!exploredNodes.contains(outNode)) {
                    size++;
                    dfs(outNode);
                }
            }
        }
    }

    public class SCC implements Comparable<SCC> {

        public final int size;
        public final Node leader;

        private SCC(int size, Node leader) {
            this.size = size;
            this.leader = leader;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", SCC.class.getSimpleName() + "[", "]")
                .add("size=" + size)
                .add("leader=" + leader)
                .toString();
        }

        @Override
        public int compareTo(SCC o) {
            return Integer.compare(o.size, this.size);
        }
    }
}
