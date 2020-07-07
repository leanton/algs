package me.antonle.stanford.algs;

import java.util.Arrays;

public class CountInversionsViaMergeSort {

    private long count;

    public CountInversionsViaMergeSort() {
        this.count = 0;
    }

    private int[] mergeAndCount(int[] input) {
        final int l = input.length;
        if (l < 2) {
            return input;
        }
        final int[] left = mergeAndCount(Arrays.copyOfRange(input, 0, l / 2));
        final int[] right = mergeAndCount(Arrays.copyOfRange(input, l / 2, l));
        return merge(left, right);

    }

    private int[] merge(int[] left, int[] right) {
        final int[] sortedArray = new int[left.length + right.length];
        int l = 0, r = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (l >= left.length) {
                sortedArray[i] = right[r++];
            } else if (r >= right.length) {
                sortedArray[i] = left[l++];
            } else if (left[l] < right[r]) {
                sortedArray[i] = left[l++];
            } else {
                sortedArray[i] = right[r++];
                count = count + (left.length - l);
            }
        }
        return sortedArray;
    }

    public long countInversions(int[] input) {
        this.mergeAndCount(input);
        return count;
    }
}
