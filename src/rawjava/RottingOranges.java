package rawjava;

import java.util.ArrayDeque;

public class RottingOranges {

    public static class Pair {
        private final int x;
        private final int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;

        ArrayDeque<Pair> deque = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    deque.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (deque.isEmpty())
            return -1;

        if (freshCount == 0)
            return 0;

        int rottenTime = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!deque.isEmpty()) {
            Pair pair = deque.remove();
            for (int i = 0; i < 4; i++) {
                int x = pair.getX() + dx[i];
                int y = pair.getY() + dy[i];

                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                    deque.add(new Pair(x, y));
                    grid[x][y] = grid[pair.getX()][pair.getY()] + 1;
                    freshCount--;
                    rottenTime = Math.max(rottenTime, grid[x][y] - 2);
                }
            }
        }

        if (freshCount == 0)
            return rottenTime;

        return -1;
    }

    public static void main(String[] args) {
        int [][] grid = {
                {2,1,1},{0, 1,1},{1,0, 1}
        };

        System.out.println(orangesRotting(grid));
    }
}
