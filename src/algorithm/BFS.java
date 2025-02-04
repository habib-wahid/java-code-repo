package algorithm;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class BFS {
    private final int V;
    private LinkedList<Integer>[] adsList;

    BFS(int V) {
        this.V = V;
        adsList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adsList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adsList[u].add(v);
        adsList[v].add(u);
    }

    public void traverse(int s) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[V];

        deque.add(s);
        visited[s] = true;

        while (!deque.isEmpty()) {
            int u = deque.removeFirst();
            System.out.println(u);
            for (int v : adsList[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    deque.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS(5);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 3);
        bfs.addEdge(2, 4);
        bfs.addEdge(3, 4);

        bfs.traverse(0);

    }

}
