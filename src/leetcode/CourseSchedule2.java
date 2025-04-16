package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CourseSchedule2 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                deque.offer(i);
            }
        }

        int i = 0;
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            res[i] = cur;

            for (int neighbor : graph.get(cur)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    deque.offer(neighbor);
                }
            }
            i++;
        }

        if (i == numCourses) {
            return res;
        }

        return new int[0];
    }
    public static void main(String[] args) {
        int[][] edges = {};
        int[] ans = findOrder(1, edges);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
