package leetcode;

import java.io.StringReader;
import java.util.*;

public class GraphValidTree {

    public static boolean isValid(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visitedParent = new HashSet<>();
        int[] visited = new int[n];

        if (!dfs(graph, visitedParent, visited, 0, 0)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean dfs(List<List<Integer>> graph, HashSet<Integer> visitedParent, int[] visited, int s, int par) {
        visitedParent.add(s);
        visited[s] = 1;

        for (int neighbor : graph.get(s)) {
            if (neighbor != par ) {
                if (visitedParent.contains(neighbor)) {
                    return false;
                }
                if (visited[neighbor] == 0) {
                   if (!dfs(graph, visitedParent, visited, neighbor, s)) {
                       return false;
                   }
                }
            }
        }

        visitedParent.remove(s);
        return true;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,0}};
        System.out.println(isValid(1, edges));
    }
}
