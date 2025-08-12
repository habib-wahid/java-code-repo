package leetcode.interviewprep;

import java.util.*;

public class GraphAlgo {

    static class WeightedPair {
        int vertex;
        int weight;

        public WeightedPair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static List<WeightedPair>[] buildWeightedGraph(int V) {
        List<WeightedPair>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        return graph;
    }

    public static List<Integer>[] buildGraph(int V) {
        List<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
           graph[i] = new ArrayList<>();
        }

        return graph;
    }

    public static void addEdge(List<Integer>[] graph, int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    public static void addDirectedEdge(List<Integer>[] graph, int u, int v) {
        graph[u].add(v);
    }

    public static void addWeightedEdge(List<WeightedPair>[] graph, int u, int v, int weight) {
        graph[u].add(new WeightedPair(v, weight));
        graph[v].add(new WeightedPair(u, weight));
    }

    //Time Complexity -> O(V + E)
    // Space Compexity -> O(V)

    public void bfs(List<Integer>[] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        Deque<Integer> queue = new ArrayDeque<>();

        visited[0] = true;
        queue.offer(0);


        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println("Vertex " + v);

            for (int u : graph[v]) {
                if (!visited[u]) {
                    visited[u] = true;
                    queue.offer(u);
                }
            }
        }
    }

    //Time Complexity -> O(V+E)
    //Space Complexity -> O(V) + Recursive stack
    public void dfs(List<Integer>[] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        dfs(graph, 0, visited);

    }

    public void dfs(List<Integer>[] graph,int currentV, boolean[] visited) {
        visited[currentV] = true;
        System.out.println("Vertex " + currentV);
        for (int u : graph[currentV]) {
            if (!visited[u]) {
                dfs(graph, u, visited);
            }
        }
    }


    public int[] shortestPath(List<WeightedPair>[] graph) {
        int V = graph.length;
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<WeightedPair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        distance[0] = 0;
        pq.offer(new WeightedPair(0, 0));

        while (!pq.isEmpty()) {
            WeightedPair curr = pq.poll();
            int currentv = curr.vertex;
            int currentweight = curr.weight;

            if (distance[currentv] < currentweight) {
                continue;
            }

            for (WeightedPair neighbour : graph[currentv]) {
                if (distance[neighbour.vertex] > currentweight + neighbour.weight) {
                    distance[neighbour.vertex] = currentweight + neighbour.weight;
                    pq.offer(new WeightedPair(neighbour.vertex, distance[neighbour.vertex]));
                }
            }
        }

        return distance;
    }

    public void topSort(List<Integer>[] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSortDfs(graph, i, visited, deque);
            }
        }

        System.out.println("Top Sort ");
        while (!deque.isEmpty()) {
            int v = deque.pollLast();
            System.out.println("Vertex " + v);
        }
    }

    public void topSortDfs(List<Integer>[] graph,int currentV, boolean[] visited, ArrayDeque<Integer> deque) {
        visited[currentV] = true;
        System.out.println("Vertex " + currentV);
        for (int u : graph[currentV]) {
            if (!visited[u]) {
                topSortDfs(graph, u, visited, deque);
            }
        }

        deque.offer(currentV);
    }


    public static void main(String[] args) {
        GraphAlgo g = new GraphAlgo();

        // Graph for Bfs and Dfs
        List<Integer>[] graph = buildGraph(5);
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 0, 4);
        addEdge(graph, 3, 4);
        g.dfs(graph);


        // Graph for Dijkstra

        List<WeightedPair>[] weightedGraph = buildWeightedGraph(5);
        addWeightedEdge(weightedGraph, 0, 1, 2);
        addWeightedEdge(weightedGraph, 0, 2, 3);
        addWeightedEdge(weightedGraph, 1, 3, 5);
        addWeightedEdge(weightedGraph, 2, 3, 2);
        addWeightedEdge(weightedGraph, 1, 4, 2);

        int[] distances = g.shortestPath(weightedGraph);

        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " " + distances[i]);
        }

        // Top Sort

        List<Integer>[] topSortGraph = buildGraph(7);
        addDirectedEdge(topSortGraph, 0, 1);
        addDirectedEdge(topSortGraph, 0, 2);
        addDirectedEdge(topSortGraph, 2, 3);
        addDirectedEdge(topSortGraph, 1, 4);
        addDirectedEdge(topSortGraph, 4, 5);
        addDirectedEdge(topSortGraph, 5, 6);
        g.topSort(topSortGraph);

       // char[][] ch = new char[5][5];

    }
}
