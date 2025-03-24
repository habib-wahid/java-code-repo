package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    static class DijkstraNode implements Comparable<DijkstraNode> {
        int vertex;
        int distance;

        public DijkstraNode(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(DijkstraNode o) {
            return this.distance - o.distance;
        }
    }


    public static int[] dijkstra(List<List<DijkstraNode>> graph) {
        int n = graph.size();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        PriorityQueue<DijkstraNode> pq = new PriorityQueue<>();
        pq.add(new DijkstraNode(0,0));

        while (!pq.isEmpty()) {
            DijkstraNode current = pq.poll();
            int vertex = current.vertex;
            int currentDistance = current.distance;
            if (currentDistance > distance[vertex]) {
                continue;
            }

            for (DijkstraNode neighbor : graph.get(vertex)) {
                if (currentDistance + neighbor.distance < distance[neighbor.vertex]) {
                    distance[neighbor.vertex] = currentDistance + neighbor.distance;
                    pq.add(new DijkstraNode(neighbor.vertex, distance[neighbor.vertex]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<DijkstraNode>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new DijkstraNode(1, 1)); // Edge from node 0 to node 1 with weight 1
        graph.get(0).add(new DijkstraNode(2, 4)); // Edge from node 0 to node 2 with weight 4
        graph.get(1).add(new DijkstraNode(2, 2)); // Edge from node 1 to node 2 with weight 2
        graph.get(1).add(new DijkstraNode(3, 5));
        graph.get(2).add(new DijkstraNode(3, 1));

        int[] shortestPath = dijkstra(graph);
        for (int i = 0; i < shortestPath.length; i++) {
            System.out.println(shortestPath[i]);
        }
    }
}
