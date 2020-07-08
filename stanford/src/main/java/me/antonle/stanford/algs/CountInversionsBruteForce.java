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

}
