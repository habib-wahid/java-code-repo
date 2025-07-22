package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class SmallestInfiniteSet {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int[] arr = new int[1001];

    public SmallestInfiniteSet() {
        for (int i = 1; i <= 1000; i++) {
            pq.add(i);
            arr[i] = 1;
        }
    }

    public int popSmallest() {
        int temp = pq.poll();
        arr[temp] = 0;
        return temp;
    }

    public void addBack(int num) {
        if (!pq.contains(num)) {
            arr[num] = 1;
            pq.add(num);
        }
    }


    public static void main(String[] args) {

    }
}
