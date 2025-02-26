package leetcode;

import java.sql.Array;
import java.util.*;

public class CourseSchedule {

    public int[] order(int numCourses, int[][] prerequisites) {

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        Set<Integer> recStack = new HashSet<>();

        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] temp : prerequisites) {
            int u = temp[0];
            int v = temp[1];
            graph[u].add(v);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, recStack, result)) {
                    return new int[0];
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public boolean dfs(List<Integer>[] graph, int source, boolean[] visited, Set<Integer> recStack, List<Integer> result) {
        visited[source] = true;
        recStack.add(source);

        for (int i : graph[source]) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, recStack, result)) {
                    return true;
                }
            } else if (recStack.contains(i)) {
                return true;
            }
        }

        result.add(source);
        recStack.remove(source);
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] data = {{1,0}, {0,1}};

        int[] result = cs.order(2, data);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        };
    }

}
