package leetcode;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        map.put(beginWord, 1);
        String characters = "abcdefghijklmnopqrstuvwxyz";

        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < characters.length(); j++) {
                    String newWord = word.substring(0, i) + characters.charAt(j) + word.substring(i + 1);
                    if (set.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, map.get(word) + 1);
                        queue.offer(newWord);
                        if (newWord.equals(endWord)) {
                            return map.get(endWord);
                        }
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log");
        System.out.println(ladderLength(beginWord, endWord, wordList));

        List<Integer> list = List.of(1,2,3,4,5);

    }
}
