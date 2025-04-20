package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpanningTree {

    static class Edge implements Comparable<Edge>{
        int source, destination, weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    static class DisjointSet {
        int[] parent, rank;
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i <n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;
            }

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> Mst = new ArrayList<>();
        int vertices = 4;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0,2, 6));
        edges.add(new Edge(0,3,5));
        edges.add(new Edge(1,3,15));
        edges.add(new Edge(2,3,4));
        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(vertices);

        int edgeCount = 0;
        int index = 0;

        while(edgeCount < vertices - 1 && index < edges.size()) {
            Edge edge = edges.get(index++);
            int sourceRoot = ds.find(edge.source);
            int destinationRoot = ds.find(edge.destination);

            if (sourceRoot != destinationRoot) {
                ds.union(sourceRoot, destinationRoot);
                Mst.add(edge);
                edgeCount++;
            }
        }

        int totalWeight = 0;
        for (Edge edge : Mst) {
            System.out.println(edge.source + " " + edge.destination + " " + edge.weight);
            totalWeight += edge.weight;
        }

        System.out.println(totalWeight);


    }
}
