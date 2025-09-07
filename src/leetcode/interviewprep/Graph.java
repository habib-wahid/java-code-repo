package leetcode.interviewprep;

import java.security.KeyStore;
import java.util.*;

public class Graph {

    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }


        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class TimePair {
        int v;
        int time;

        public TimePair(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public List<List<Integer>> solution1(int[][] height) {
        int rows = height.length;
        int cols = height[0].length;
        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        Map<Pair, Integer> pacificMap = new HashMap<>();
        Map<Pair, Integer> atlanticMap = new HashMap<>();


        for (int i = 0; i < cols; i++) {
            if (!pacificVisited[0][i]) {
                dfs(height, rows, cols, pacificVisited, 0, i, pacificMap);
            }

            if (!atlanticVisited[rows - 1][i]) {
                dfs(height, rows, cols, atlanticVisited, rows - 1, i, atlanticMap);
            }
        }


        for (int i = 0; i < rows; i++) {
            if (!pacificVisited[i][0]) {
                dfs(height, rows, cols, pacificVisited, i, 0, pacificMap);
            }

            if (!atlanticVisited[i][cols - 1]) {
                dfs(height, rows, cols, atlanticVisited, i, cols - 1, atlanticMap);
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificMap.containsKey(new Pair(i, j)) && atlanticMap.containsKey(new Pair(i, j))) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;

    }

    public void dfs(int[][] height, int rows, int column, boolean[][] visited, int i, int j, Map<Pair, Integer> map) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        visited[i][j] = true;
        map.put(new Pair(i, j), 1);

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < rows && y >= 0 && y < column && !visited[x][y] && height[x][y] >= height[i][j]) {
                dfs(height, rows, column, visited, x, y, map);
            }
        }
    }

    public String solution(String[] words) {
        int listLen = words.length;
        int maxWordLength = 0;
        for (int i = 0; i < listLen; i++) {
            maxWordLength = Math.max(maxWordLength, words[i].length());
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = new char[27];

        for (int i = 1; i < 27; i++) {
            chars[i] = ' ';
        }

        int count = 0;
        for (int i = 0; i < maxWordLength; i++) {
            char prev = '0';
            for (int j = 0; j < listLen; j++) {
                System.out.println(i + " " + words[j]);
                if (i > words[j].length() - 1) {
//                    if (j - 1 >= 0 && words[j].length() < words[j - 1].length() ) {
//                        return "";
//                    }
                    continue;
                }
                char c = words[j].charAt(i);
                int val = map.getOrDefault(c, 0);

                if (val == 0) {
                    count++;
                  //  System.out.println(count);
                    map.put(c, count);
                    chars[count] = c;
                 //   System.out.println(chars[count]);
                } else {
                   int prevVal = map.getOrDefault(prev, 0);
                   if (prevVal > map.get(c)) {
                       return "";
                   }
                }

                prev = c;
            }
        }

        System.out.println("here1");
        for (int i = 1; i < 27; i++) {
            System.out.println("here");
            if (chars[i] != ' ') {
                System.out.println(chars[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 27; i++) {
            if (chars[i] != ' ') {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<TimePair>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int d = time[2];

            map.get(u).add(new TimePair(v, d));
        }

        int[] dest = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dest[i] = Integer.MAX_VALUE;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        dest[k] = 0;
        queue.offer(k);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (TimePair pair : map.get(u)) {
                int v = pair.v;
                int t = pair.time;

                if (dest[u] + t >= dest[v]) {
                    continue;
                }

                dest[v] = dest[u] + t;
                queue.offer(v);
            }
        }

        int min = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (dest[i] == Integer.MAX_VALUE) {
                return -1;
            }

            min = Math.max(min, dest[i]);
        }

        return min;
    }

    public void surroundedRegions(char[][] board) {
        int len = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[len][width];
        Deque<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < width; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    System.out.println("here1");
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    boolean check = checkIfSurrounded(board,visited, queue);
                    System.out.println("Here");
                    if (check) {
                        queue.offer(new int[]{i, j});
                        color(board, queue);
                    }
                }
            }
        }
    }

    public void color(char[][] board, Deque<int[]> queue) {
        int[][] dxdy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            board[x][y] = 'X';

            for (int i = 0; i < 4; i++) {
                int newX = x + dxdy[i][0];
                int newY = y + dxdy[i][1];

                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'O') {
                    System.out.println("x y" + newX + " " + newY);

                    queue.offer(new int[]{newX, newY});
                }

               // queue.offer(new int[]{newX, newY});
            }
        }
    }
    public boolean checkIfSurrounded(char[][] board, boolean[][] visited, Deque<int[]> queue) {
        boolean flag = true;
        int[][] dxdy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
                flag = false;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dxdy[i][0];
                int newY = y + dxdy[i][1];

                if (newX >=0 && newX < board.length && newY >=0 && newY < board[0].length && board[newX][newY] == 'O' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return flag;
    }
    public boolean validTree (int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        bfsGraph(graph, visited, 0);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
    public int wordLadder(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }

        if (wordList.isEmpty())
            return 0;

        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        for (String word : wordList) {
            if (!word.equals(beginWord)) {
                map.put(word, 0);
            }
        }

        if (!map.containsKey(endWord))
            return 0;

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add(beginWord);

        while (!deque.isEmpty()) {
            String parent = deque.pop();
            int parValue = map.get(parent);

            for (int i = 0; i < wordList.size(); i++) {
                String child = wordList.get(i);
                if (map.get(child) == 0) {
                    int charDiff = wordDiff(parent, child);
                    if (charDiff == 1) {
                        deque.add(child);
                        map.put(child, parValue + 1);
                    }
                }
            }
        }

        return map.get(endWord);
    }

    public int wordDiff(String parent, String child) {
        int charDiff = 0;
        for (int i = 0; i < parent.length(); i++) {
            if (parent.charAt(i) != child.charAt(i)) {
                charDiff++;
            }
        }

        return charDiff;
    }

    public int[] redundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int parU = find(edge[0], parent);
            int parV = find(edge[1], parent);
            if (parU == parV) {
                return new int[]{edge[0], edge[1]};
            } else {
                parent[parV] = parU;
            }
        }
        return new int[]{};
    }

    public int find(int u, int[] parent) {
        if (u == parent[u]) {
            return u;
        }
        parent[u] = find(parent[u], parent);
        return parent[u];
    }

    public int connectedComponentsBfsApproach(int n, int[][] edges) {
        if (n <= 1)
            return 1;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                bfsGraph(graph, visited, i);
            }
        }

        return count;
    }

    public void bfsGraph(List<List<Integer>> graph, boolean[] visited, int i) {
        visited[i] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : graph.get(cur)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
    public int[] courseSchedule2(int numCourses, int[][] prerequisites) {

        if (numCourses <= 1)
        {
            int[] res = new int[numCourses];
            res[0] = 0;
            return res;
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] cur = prerequisites[i];
            graph.get(cur[1]).add(cur[0]);
        }

        int[] color = new int[numCourses];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == 0) {
                if (!traverseGraph(graph, color, i, queue)) {
                    return new int[0];
                }
            }
        }

        int[] res = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int cur = queue.pollLast();
            System.out.println(cur);
            res[i++] = cur;
        }
        return res;
    }

    public boolean courseSchedule(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        if (numCourses <= 1)
            return true;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] cur = prerequisites[i];
            graph.get(cur[1]).add(cur[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            System.out.println(graph.get(i));
        }
        int[] color = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (color[i] == 0) {
                if (!traverseGraph(graph, color, i, new ArrayDeque<>())) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean traverseGraph(ArrayList<ArrayList<Integer>> graph, int[] color, int v, ArrayDeque<Integer> queue) {
        color[v] = 1;
        for (int u : graph.get(v)) {
            if (color[u] == 1)
                return false;
            if (color[u] == 0 && !traverseGraph(graph, color, u, queue))
                return false;
        }
        color[v] = 2;
        queue.addLast(v);
        return true;
    }

    public void surroundRegion(char[][] board) {
        int len = board.length;
        int width = board[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 1; i < len - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (board[i][j] == 'O') {
                    queue.offer(new int[]{i, j});
                    bfs(board, queue);
                }
            }
        }
    }

    public void bfs(char[][] board, Deque<int[]> queue) {
        int[] dx = {-1, 1, 0, 0, 0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dx[i + 4];

                if (board[x][y] == 'X') {
                    board[cur[0]][cur[1]] = 'X';
                    break;
                }
            }

           if (board[cur[0]][cur[1]] == 'X') {
               for (int i = 0; i < 4; i++) {
                   int x = cur[0] + dx[i];
                   int y = cur[1] + dx[i + 4];

                   if (x >= 1 && x <= board.length - 1 && y >= 1 && y <= board[0].length - 1 && board[x][y] == 'O') {
                       queue.offer(new int[]{x, y});
                   }
               }
           }
        }
    }

    public int rottingOranges(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] time = new int[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {-1, 1, 0, 0, 0, 0, 1, -1};
        int max = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dx[i + 4];

                if (x < 0 || x >= length || y < 0 || y >= width || grid[x][y] != 1)
                    continue;

                time[x][y] = time[poll[0]][poll[1]] + 1;
                grid[x][y] = 2;
                queue.offer(new int[]{x, y});
                max = Math.max(max, time[x][y]);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return max;

    }
    public void islandsAndTreasure(int[][] grid) {
        int len = grid.length;
        int width = grid[0].length;

        boolean[][] visited = new boolean[len][width];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dxdy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dxdy[i][0];
                int y = cur[1] + dxdy[i][1];

                if (x < 0 || x >= len || y < 0 || y >= width || grid[x][y] != Integer.MAX_VALUE)
                    continue;

                grid[x][y] = grid[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{x, y});

            }
        }
    }

    /// Time Complexity
    /// Space Complexity
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        buildMap(map, node);
        setNeighbours(map);

        return map.get(node);
    }

    public void setNeighbours(Map<Node, Node> map) {
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node key = entry.getKey();
            Node value = entry.getValue();
            for (Node neighbor : key.neighbors) {
                value.neighbors.add(map.get(neighbor));
            }
        }
    }
    public void buildMap(Map<Node, Node> map, Node node) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    map.put(neighbor, new Node(neighbor.val));
                }
            }
        }
    }

   /// Time Complexity O(l * w)
   /// Space Complexity O(L * W)

    public int maxAreaOfIsland(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;

        boolean[][] visited = new boolean[length][width];
        Deque<Pair> queue = new ArrayDeque<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new Pair(i, j));
                    maxArea = Math.max(maxArea, maxArea(grid, visited, queue));
                }
            }
        }

        return maxArea;
    }

    public int maxArea(int[][] grid, boolean[][] visited, Deque<Pair> queue) {
        int area = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            area++;
            for (int i = 0; i < 4; i++) {
                int x = pair.x + dx[i];
                int y = pair.y + dy[i];
                if (x>=0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] == 1) {
                    queue.offer(new Pair(x, y));
                    visited[x][y] = true;
                }
            }
        }

        return area;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','O','O','X'},
                {'X','X','X','O'}
        };

        Graph g = new Graph();
      //  g.solution(grid);

        int[][] prerequisites = {
                {1, 0}, {0, 2}
        };

        String[] words = {"hrn","hrf","er","enn","rfnn"};

        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

      //  g.solution(words);
        System.out.println(g.solution1(heights));

    }

}
