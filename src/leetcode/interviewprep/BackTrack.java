package leetcode.interviewprep;

import java.util.ArrayList;
import java.util.List;

public class BackTrack {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static boolean solution(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfsCheck(board, word, i, j, 0)) {
                   return true;
                }
            }
        }



        return false;
    }

    public static boolean dfsCheck(char[][] board,String word, int i, int j, int idx) {
      if (board[i][j] != word.charAt(idx)) {
          return false;
      }

      if (idx == word.length() - 1) {
          return true;
      }

      char temp = board[i][j];
      board[i][j] = '#';

       for (int k = 0; k < 4; k++) {
           int x = i + dx[k];
           int y = j + dy[k];

           if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '#') {
               if (dfsCheck(board, word, x, y, idx + 1)) {
                   board[i][j] = temp;
                   return true;
               }
           }
       }

      board[i][j] = temp;

       return false;

    }

    public static List<List<Integer>> combinationSUm(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            int currentSum = nums[i];
            temp.add(nums[i]);
            backTrack(nums, temp, currentSum, target, i, res);

        }

        return res;
    }

    public static void backTrack(int[] nums, List<Integer> temp, int currentSum, int target, int startIdx, List<List<Integer>> res) {
        if (currentSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (currentSum > target) {
            return;
        }

        for (int i = startIdx; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(nums, temp, currentSum + nums[i], target, i, res);
            temp.remove(temp.size() - 1);
        }

    }


    static void main() {

        int[] nums = new int[] {3,4,5};
        int target = 16;

        char[][] board = {
                {'A', 'B', 'C', 'D'},
                {'S', 'A', 'A', 'T'},
                {'A', 'C', 'A', 'E'}
        };

        String word = "CAT";


        StringBuilder sb = new StringBuilder();
        sb.append("A");
       // System.out.println(sb.toString().length());
        System.out.println(solution(board, word));
    }
}
