package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {

    int k;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
    }

    public int add (int val) {
        int temp = k;
        maxHeap.add(val);
        List<Integer> list = new ArrayList<>();
        while (--temp > 0) {
            list.add(maxHeap.poll());
        }

        int res = maxHeap.peek();
        maxHeap.addAll(list);
        return res;
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{1, 2, 3, 3});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(6));
        System.out.println(kthLargest.add(7));
    }
}
