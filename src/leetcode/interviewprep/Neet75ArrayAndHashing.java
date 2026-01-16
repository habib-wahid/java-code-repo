package leetcode.interviewprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Neet75ArrayAndHashing {

    public static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean solution(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], map.getOrDefault(nums[0], 0) + 1);
        int[] array = new int[len];
        ArrayList<Integer>[] list = new ArrayList[len];
        ArrayList<Integer> list1 = new ArrayList<>();

        if (list[0] == null) {
            list[0] = new ArrayList<>();
        }

        list1.addAll(list[0]);
        int[] arr = list1.subList(0, 1).stream().mapToInt(Integer::intValue).toArray();



        for (int key : map.keySet()) {
            int val = map.get(key);
        }

        Set<Integer> set = new HashSet<>();
        set.add(nums[1]);
        set.remove(nums[2]);
        set.add(nums[0]);
        set.contains(nums[0]);
        String s = "sfsdfsd";
        Map<Integer, Integer> map1 = new HashMap<>();

        PriorityQueue<Pair> queue = new PriorityQueue<>((pai1, pai2) -> (pai2.y - pai1.y));
        queue.offer(new Pair(nums[0], 2));
        queue.offer(new Pair(nums[1], 1));

        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("world");

        StringBuilder sb = new StringBuilder();
        sb.append(stringList.get(0));
        sb.append(stringList.get(1));

        return true;

    }

    static void main() {
        List<String> strs = Arrays.asList("hello", "world");

        String[] s = {"a", "b", "c"};
        Arrays.stream(s).filter(str -> !str.equals("emptyString")).toList()
    }
}
