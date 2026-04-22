package leetcode.interviewprep;

import java.util.ArrayDeque;
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

    public int instanceValue = 0;

    public static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean solution(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (target == matrix[0][0])
            return true;

        if (target < matrix[0][0])
            return false;

        int sr = 0, er = m - 1;

        while (sr <= er) {
            int mid = (sr + er) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][n-1] ) {
                int left = 0, right = n - 1;


                while (left <= right) {

                    if (left == right) {
                        if (target == matrix[mid][left]) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    int mi = (left + right)/2;
                    if (target == matrix[mid][mi]) {
                        return true;
                    } else if (target < matrix[mid][mi]) {
                        right = mi - 1;
                    } else {
                        left = mi + 1;
                    }
                }
                return false;
            } else if (target < matrix[mid][0]) {
                er = mid - 1;
            } else {
                sr = mid + 1;
            }
        }

        return false;

    }

    static void main() {

       //  1  3   5  7
       //  10 11  16 20
       //  23 30  34 60

       int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
       int target = 13;
       System.out.println(solution(matrix, target));


        String text = """
                This is a multi-line string in Java 15 and above. It preserves the formatting and can contain "quotes" without needing to escape them.
                """;
    //    System.out.println(text);


    }
}
