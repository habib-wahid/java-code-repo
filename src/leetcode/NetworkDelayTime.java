package leetcode;

import java.util.*;

public class NetworkDelayTime {

    static class NetworkNode implements Comparable<NetworkNode> {
        int dest;
        int time;
        public NetworkNode(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }

        @Override
        public int compareTo(NetworkNode o) {
            return this.time - o.time;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<NetworkNode>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new NetworkNode(time[1], time[2]));
        }
        int[] visited = new int[n + 1];
        PriorityQueue<NetworkNode> pq = new PriorityQueue<>();
        pq.add(new NetworkNode(k, 0));
        return dijkstra(pq, graph, visited, n, k);
    }

    public static int dijkstra(PriorityQueue<NetworkNode> pq, List<List<NetworkNode>> graph, int[] visited, int n, int k) {
        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        visited[k] = 1;
        time[k] = 0;

        while (!pq.isEmpty()) {
            NetworkNode node = pq.poll();
            visited[node.dest] = 1;

            if (node.time > time[node.dest]) {
                continue;
            }

            for (NetworkNode neighbor : graph.get(node.dest)) {
                if (node.time + neighbor.time < time[neighbor.dest]) {
                    time[neighbor.dest] = node.time + neighbor.time;
                    pq.add(new NetworkNode(neighbor.dest, time[neighbor.dest]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                return -1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, time[i]);
        }

        return max;

    }
    public static void main(String[] args) {
        int[][] times = {{1,2,1}};
        System.out.println(networkDelayTime(times, 2, 2));
    }
}
