package me.antonle.stanford.algs;

public class CountInversionsBruteForce {

    /**
     * Brute-force algorithm to count the inversions
     **/
    public static long countInversionsBF(int[] input) {
        long count = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static IO countInversionsDC(IO input) {
        int n = input.sortedOut.length;
        if (n == 1) {
            return new IO(input.sortedOut, 0);
        }
        return null;
    }

    private static class IO {

        public final int[] sortedOut;
        public final int inversions;

        public IO(int[] sortedOut, int inversions) {
            this.sortedOut = sortedOut;
            this.inversions = inversions;
        }
    }

}
