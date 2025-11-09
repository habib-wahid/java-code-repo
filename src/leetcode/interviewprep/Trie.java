package leetcode.interviewprep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Trie {

    TrieNode root;
    Trie() {
        this.root = new TrieNode();
    }

    static class TrieNode {
        TrieNode[] children;
        String word;
        boolean isEnd;
        int count;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
            word = "";
            count = 0;
        }
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        return solution(word, 0, root);
    }

    public boolean solution(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && solution(word, index + 1, child)) {
                    return true;
                }
            }

            return false;
        } else {
            node = node.children[c - 'a'];
            if (node == null) {
                return false;
            }
            return solution(word, index + 1, node);
        }

    }

    public static List<String> wordSearch2(char[][] board, String[] words) {
        TrieNode trieNode = new TrieNode();

        for (String word : words) {
            TrieNode rootNode = trieNode;
            for (char c : word.toCharArray()) {
                if (rootNode.children[c - 'a'] == null) {
                    rootNode.children[c - 'a'] = new TrieNode();
                }
                rootNode = rootNode.children[c - 'a'];
            }

            rootNode.isEnd = true;
            rootNode.word = word;
        }

        Set<String> set = new HashSet<>();

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                TrieNode node = trieNode;
                if (node.children[board[i][j] - 'a'] != null) {
                    node = node.children[board[i][j] - 'a'];
                    dfs(board, node, set, i, j, m, n, visited);
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void dfs(char[][] board, TrieNode node,
                    Set<String> set, int i, int j, int m, int n, boolean[][] visited) {
        visited[i][j] = true;

        if (node.isEnd) {
            set.add(node.word);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {

            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && node.children[board[x][y] - 'a'] != null) {
                dfs(board, node.children[board[x][y] - 'a'], set, x, y, m, n, visited);
            }
        }

        visited[i][j] = false;
    }


    public static List<Integer> contacts(List<List<String>> queries) {
        int len = queries.size();
        TrieNode root = new TrieNode();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            String key = queries.get(i).get(0);
            String value = queries.get(i).get(1);
            if (key.equals("add")) {
                TrieNode node = root;
                for (char c : value.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node = node.children[c - 'a'];
                    node.count++;
                }
                node.isEnd = true;
            } else if (key.equals("find")) {
                TrieNode node = root;
                for (int j = 0; j < value.length(); j++) {

                    if (node.children[value.charAt(j) - 'a'] == null) {
                        res.add(0);
                        break;
                    }
                    node = node.children[value.charAt(j) - 'a'];
                    if (j == value.length() - 1) {
                        res.add(node.count);
                    }
                }
            }
        }

        return res;
    }

    static void main() {

        char[][] board = {
                {'a', 'b', 'c', 'd'},
                {'s', 'a', 'a', 't'},
                {'a', 'c', 'k', 'e'},
                {'a', 'c', 'd', 'n'}
        };
        String[] words = {"bat","cat","back","backend","stack"};
    //    System.out.println(wordSearch2(board, words));

        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(List.of("add", "ed")));
        queries.add(new ArrayList<>(List.of("add", "eddie")));
        queries.add(new ArrayList<>(List.of("add", "edward")));
        queries.add(new ArrayList<>(List.of("find", "ed")));
        queries.add(new ArrayList<>(List.of("add", "edwina")));
        queries.add(new ArrayList<>(List.of("find", "edw")));
        queries.add(new ArrayList<>(List.of("find", "a")));

        System.out.println(contacts(queries));


    }
}
