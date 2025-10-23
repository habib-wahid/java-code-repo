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
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
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

    public static List<String> solution1(char[][] board, String[] words) {
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
                    dfs(board, node, set, board[i][j] + "", i, j, m, n, -1, -1);
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void dfs(char[][] board, TrieNode node,
                    Set<String> set, String st, int i, int j, int m, int n, int parentI, int parentJ) {
     //   visited[i][j] = true;
        if (node.isEnd) {
            set.add(st);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x == parentI && y == parentJ) {
                continue;
            }
            if (x >= 0 && x < m && y >= 0 && y < n && node.children[board[x][y] - 'a'] != null) {
                dfs(board, node.children[board[x][y] - 'a'], set, st + board[x][y], x, y, m, n, i, j);
            }
        }
    }


    static void main() {

        char[][] board = {
                {'a', 'b', 'c', 'd'},
                {'s', 'a', 'a', 't'},
                {'a', 'c', 'k', 'e'},
                {'a', 'c', 'd', 'n'}
        };

        char[][] board2 = {
                {'x', 'x'},
                {'x', 'x'}
        };
        String[] words2 = {"xxxxx"};
        String[] words = {"bat","cat","back","backend","stack"};

        char[][] board3 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        char[][] board4 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words3 = {"oath","pea","eat","rain"};
        String[] words4 = {"oath","pea","eat","rain","hklf","hf"};

        System.out.println(solution1(board2, words2));


    }
}
