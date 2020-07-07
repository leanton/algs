package me.antonle.stanford.algs;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] input) {
        final int l = input.length;
        if (l == 1) {
            return input;
        }
        final int[] left = mergeSort(Arrays.copyOfRange(input, 0, l / 2));
        final int[] right = mergeSort(Arrays.copyOfRange(input, l / 2, l));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
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
            }
        }
        return sortedArray;
    }

}
