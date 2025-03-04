package leetcode;

import java.util.ArrayDeque;

public class NumberOfIslands {

    private static class Pair {
        public int row; public int col;
        public Pair (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static int numsIslands(char[][] grid) {
        int row = grid.length; int col = grid[0].length;
        int maxArea = 0;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j, visited));
                }
            }
        }

        return maxArea;
    }


    public static int bfs(char[][] grid, int row, int col, boolean[][] visited) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        ArrayDeque<Pair> deque = new ArrayDeque<>();

        visited[row][col] = true;
        deque.add(new Pair(row, col));
        int count = 1;

        while (!deque.isEmpty()) {
            Pair pair = deque.poll();
            for (int i = 0; i < 4; i++) {
                    int newRow = pair.row + dx[i];
                    int newCol = pair.col + dy[i];
                    if (newRow >= 0 && newRow < grid.length && newCol >=0
                            && newCol < grid[0].length && grid[newRow][newCol] == '1'
                            && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        deque.add(new Pair(newRow, newCol));
                        count++;
                    }
            }
        }

        return count;
    }



    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numsIslands(grid));

    }
}
