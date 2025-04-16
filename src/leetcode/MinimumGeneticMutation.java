package leetcode;

import java.util.*;

public class MinimumGeneticMutation {

    public static int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }

        return solution(startGene, endGene, bank);
    }

    public static int solution(String startGene, String endGene
            , String[] bank) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(startGene, 0);
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.offer(startGene);
        Set<String> set = new HashSet<>(List.of(bank));

        if (!set.contains(endGene)) {
            return -1;
        }
        String st = "ACGT";

        while (!deque.isEmpty()) {
            String s = deque.poll();
            for (int j = 0; j < st.length(); j++) {
                for (int i = 0; i < s.length(); i++) {
                    String newString = s.substring(0, i) + st.charAt(j) + s.substring(i + 1);
                    if (set.contains(newString) && !map.containsKey(newString)) {
                        map.put(newString, map.get(s) + 1);
                        deque.offer(newString);
                    }
                }
            }
        }

        return map.getOrDefault(endGene, -1);
    }
    public static void main(String[] args) {
        String start = "AACCGGTT"; String end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation(start, end, bank));
    }
}
