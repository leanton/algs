package me.antonle.stanford.algs;

import java.util.Arrays;

public class QuickSort {

    private long comparisons;

    public QuickSort() {
        this.comparisons = 0;
    }

    public void quickSort(int[] input) {
        quickSort(input, 0, input.length);
        System.out.println(comparisons);
    }

    private void quickSort(int[] input, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 2) {
            return;
        }
        choosePivot(input, leftIndex, rightIndex);
        final int pivotIndex = partition(input, leftIndex, rightIndex);
        quickSort(input, leftIndex, pivotIndex);
        quickSort(input, pivotIndex + 1, rightIndex);
    }

    private void choosePivot(int[] input, int l, int r) {
//        swap(input, l, r - 1);
        // first element on the left
        //
        final int firstElem = input[l];
        final int lastElem = input[r - 1];
        final int middleElem = input[(r + l - 1) / 2];
        final int[] ints = {firstElem, lastElem, middleElem};
        Arrays.sort(ints);
        if (ints[1] == middleElem) {
            swap(input, l, (r + l - 1) / 2);
            return;
        }
        if (ints[1] == lastElem) {
            swap(input, l, r - 1);
        }
    }

    private int partition(int[] input, int l, int r) {
        final int p = input[l];
        int i = l + 1;
        for (int j = l + 1; j < r; j++) {
            if (input[j] < p) {
                final int temp = input[j];
                input[j] = input[i];
                input[i] = temp;
                i++;
            }
        }
        input[l] = input[i - 1];
        input[i - 1] = p;

        this.comparisons += (r - l - 1);

        return i - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
