package algorithm;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    List<List<Integer>> graph;
    boolean[] visited;

    public DFS(List<List<Integer>> graph, boolean[] visited) {
        this.graph = graph;
        this.visited = visited;
    }

    public void recursiveDFS(int source) {
        System.out.print(source + " ");
        visited[source] = true;

        for (int neighbor : graph.get(source)) {
            if (!visited[neighbor]) {
                recursiveDFS(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(List.of(1,2,3));
        graph.add(List.of(0, 2));
        graph.add(List.of(0,1, 4));
        graph.add(List.of(0));
        graph.add(List.of(2));

        DFS dfs = new DFS(graph, new boolean[graph.size()]);
        dfs.recursiveDFS(0);

    }
}
