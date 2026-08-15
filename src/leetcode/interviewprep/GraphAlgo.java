package leetcode.interviewprep;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GraphAlgo {

    static class GraphPair {
        int node;
        int weight;
        public GraphPair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static List<Integer>[] createGraph(int V) {
        List<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    public static List<GraphPair>[] createWeightedGraph(int V) {
        List<GraphPair>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    public static void addEdge(List<Integer>[] graph, int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    public static void addWeightedEdge(List<GraphPair>[] graph, int u, int v, int weight) {
        graph[u].add(new GraphPair(v, weight));
        graph[v].add(new GraphPair(u, weight));
    }

    public static void addDirectedEdge(List<Integer>[] graph, int u, int v) {
        graph[u].add(v);
    }

    public static void bfsTraversal(List<Integer>[] graph, int s) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[graph.length];

        q.offer(s);
        visited[s] = 1;

        System.out.println("Printing BFS Traversal Nodes of a graph: -----------------------");
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.println("Visited: " + u);

            for (int v : graph[u]) {     // here complexity is total edges
                if (visited[v] == 0) {
                    q.offer(v);
                    visited[v] = 1;      // here complexity is total nodes
                }
            }
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Total Runtime complexity becomes: O(V+E)");
        System.out.println("Total Space complexity becomes: O(V)");
    }


    public static void dfsTraversal(List<Integer>[] graph, int s) {
        int[] visited = new int[graph.length];
        System.out.println("Printing DFS Traversal Nodes of a graph: -----------------------");
        dfs(graph, s, visited);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Total Runtime complexity becomes: O(V+E)");
        System.out.println("Total Space complexity becomes: O(V)");
    }

    public static void dfs(List<Integer>[] graph, int s, int[] visited) {
        visited[s] = 1;
        System.out.println("Visited: " + s);


        for (int v : graph[s]) {    // here complexity is total edges
            if (visited[v] == 0) {
                dfs(graph, v, visited);  //here complexity is total nodes
            }
        }

    }

    public static boolean detectCycle(List<Integer>[] graph) {
        System.out.println("Detecting Cycle in a directed graph using DFS: -----------------------");
        int[] nodeState = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (nodeState[i] == 0) {
                if (cycle(graph, i, nodeState)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycle(List<Integer>[] graph, int s, int[] nodeState) {
        if (nodeState[s] == 1)
            return true;
        if (nodeState[s] == 2)
            return false;

        nodeState[s] = 1;
        System.out.println("Visited: " + s);

        for (int v : graph[s]) {
            if (cycle(graph, v, nodeState)) {
                return true;
            }
        }

        nodeState[s] = 2;
        return false;
    }



    public static int[] diajkstra(List<GraphPair>[] graph, int s) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        Queue<GraphPair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new GraphPair(s, 0));

        while(!pq.isEmpty()) {
            GraphPair current = pq.poll();  // here complexity is total nodes poll which is 0(logV)
            int u = current.node;
            int currentDistance = current.weight;

            if (currentDistance > dist[u]) {
                continue;
            }
            System.out.println("Visited: " + u);

            for (GraphPair v : graph[u]) {  // here complexity is total edges
                if (currentDistance + v.weight < dist[v.node]) {
                    dist[v.node] = currentDistance + v.weight;
                    pq.add(new GraphPair(v.node, dist[v.node]));    // here complexity is total nodes insert which is 0(logV)
                }
            }
        }

        return dist;
    }


    public static int[] topologicalSortBFS(List<Integer>[] graph) {
        List<Integer> res = new ArrayList<>();
        int[] degree = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {  // here complexity is total nodes
            for (int v : graph[i]) {
                degree[v]++;
            }
        }

        for (int i = 0; i < graph.length; i++) {  // here complexity is total nodes
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            res.add(u);

            for (int v : graph[u]) {   // here complexity is total edges
                degree[v]--;
                if (degree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static int[] topSortDfs(List<Integer>[] graph) {
        int [] visited = new int[graph.length];
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                topSort(graph, i, visited, stack);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < graph.length; i++) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void topSort(List<Integer>[] graph, int s, int[] visited, Stack<Integer> stack) {
        visited[s] = 1;

        for (int v : graph[s]) {
            if (visited[v] == 0) {
                topSort(graph, v, visited, stack);
            }
        }

        stack.push(s);
    }

    static void main(String[] args) {
        System.out.println("Hello from GraphAlgo");

        //Graph Traversal Algorithms
        List<Integer>[] graph = createGraph(5);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 2, 4);

        bfsTraversal(graph, 0);
        dfsTraversal(graph, 0);

        //Graph Cycle Detection Algorithms
        List<Integer>[] cGraph = createGraph(4);
        addDirectedEdge(cGraph, 0, 1);
        addDirectedEdge(cGraph, 1, 2);
        addDirectedEdge(cGraph, 2, 3);
       // addDirectedEdge(cGraph, 2, 0);
        System.out.println("Cycle exists: " + detectCycle(cGraph));

        // Dijkstra's Algorithm

        List<GraphPair>[] weightedGraph = createWeightedGraph(5);
        addWeightedEdge(weightedGraph, 0, 1, 4);
        addWeightedEdge(weightedGraph, 0, 2, 8);
        addWeightedEdge(weightedGraph, 1, 2, 3);
        addWeightedEdge(weightedGraph, 1, 4, 6);
        addWeightedEdge(weightedGraph, 2, 3, 2);
        addWeightedEdge(weightedGraph, 3, 4, 10);


        int[] distances = diajkstra(weightedGraph, 0);
        System.out.println("Shortest distances from node 0: " + Arrays.toString(distances));
        System.out.println("Total Runtime complexity becomes: O((V+E)logV)");
        System.out.println("Total Space complexity becomes: O(V)");

        // Topological Sorting
        List<Integer>[] tGraph = createGraph(6);
        addDirectedEdge(tGraph, 0, 1);
        addDirectedEdge(tGraph, 1, 2);
        addDirectedEdge(tGraph, 2, 3);
        addDirectedEdge(tGraph, 4, 5);
        addDirectedEdge(tGraph, 5, 1);
        addDirectedEdge(tGraph, 5, 2);

        int[] topologicalOrder = topologicalSortBFS(tGraph);
        System.out.println("Topological Order: " + Arrays.toString(topologicalOrder));
        System.out.println("Total Runtime complexity becomes: O(V+E)");
        System.out.println("Total Space complexity becomes: O(V)");

        int[] topologicalOrder1 = topSortDfs(tGraph);
        System.out.println("Topological Order: " + Arrays.toString(topologicalOrder1));

    }
}
