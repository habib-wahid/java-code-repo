package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    static class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs (int[] num1, int[] num2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> num1[p.i] + num2[p.j]));

        for (int i = 0; i < num1.length; i++) {
            pq.offer(new Pair(i, 0));
        }

        List<List<Integer>> res = new ArrayList<>();

        while (k > 0 && !pq.isEmpty()) {
            Pair p = pq.poll();
            res.add(List.of(num1[p.i], num2[p.j]));

            if (p.j < num2.length - 1) {
                pq.offer(new Pair(p.i, p.j + 1));
            }
            k--;
        }

        return res;
    }
    public static void main(String[] args) {
        FindKPairsWithSmallestSums findKPairsWithSmallestSums = new FindKPairsWithSmallestSums();
        System.out.println(findKPairsWithSmallestSums.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2));
    }
}
