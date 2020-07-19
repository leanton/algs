package me.antonle.stanford.algs;

import java.util.PriorityQueue;

public class HeapMedian {

    private final PriorityQueue<Integer> minQ;
    private final PriorityQueue<Integer> maxQ;

    public HeapMedian() {
        this.minQ = new PriorityQueue<>();
        this.maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public int median() {
        assert !minQ.isEmpty();
        return minQ.size() > maxQ.size() ? minQ.peek() : maxQ.peek();
    }

    public void add(int elem) {
        if (minQ.isEmpty()) {
            minQ.add(elem);
            return;
        }
        if (maxQ.isEmpty()) {
            maxQ.add(elem);
            return;
        }

        final Integer maxElem = maxQ.peek();
        if (elem < maxElem) {
            maxQ.add(elem);
        } else {
            minQ.add(elem);
        }
        rebalance();
    }

    private void rebalance() {
        final int diff = minQ.size() - maxQ.size();
        if (diff > 1) {
            maxQ.add(minQ.poll());
        } else if (diff < -1) {
            minQ.add(maxQ.poll());
        }
    }

}
