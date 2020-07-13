package me.antonle.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Good article on how to approach batracking problems in general:
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> ll = new LinkedList<>();
        ll.add(List.of());

        while (ll.peekFirst().size() != nums.length) {
            final List<Integer> list = ll.pollFirst();
            for (int num : nums) {
                if (!list.contains(num)) {
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(num);
                    ll.addLast(tmp);
                }
            }
        }
        return ll;
    }

}
