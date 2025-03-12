package leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class EvaluateDivision {

    static class WeightedPair {
        String dest;
        double weight;
        public WeightedPair(String dest, double weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static double[] evaluate(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<WeightedPair>> map = new HashMap<>();
        int count = 0;
        for (List<String> equation : equations) {
            String from = equation.get(0);
            String to = equation.get(1);

            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }

            if (!map.containsKey(to)) {
                map.put(to, new ArrayList<>());
            }

            map.get(from).add(new WeightedPair(to, values[count]));
            map.get(to).add(new WeightedPair(from, 1.0/values[count]));
            count++;
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);

            if (map.containsKey(from)) {
                result[i] = bfs(map, from, to);
            } else {
                result[i] = -1.0;
            }

        }

        for (int i = 0; i < queries.size(); i++) {
            System.out.println(result[i]);
        }

        return result;
    }


    public static double bfs (Map<String, List<WeightedPair>> map, String from, String to) {
        Map<String, Boolean> visited = new HashMap<>();
        ArrayDeque<WeightedPair> queue = new ArrayDeque<>();
        visited.put(from, true);
        queue.offer(new WeightedPair(from, 1.0));

        while (!queue.isEmpty()) {
            WeightedPair pair = queue.poll();
            for (WeightedPair neighbor : map.get(pair.dest)) {
                if (neighbor.dest.equals(to)) {
                    return pair.weight * neighbor.weight;
                }

                if (!visited.containsKey(neighbor.dest)) {
                    queue.offer(new WeightedPair(neighbor.dest, pair.weight * neighbor.weight));
                    visited.put(neighbor.dest, true);
                }
            }
        }

        return -1.0;
    }


//    public static double[] evaluate(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        // Graph representation
//        Map<String, List<WeightedPair>> graph = new HashMap<>();
//
//        // Build graph with bidirectional edges
//        for (int i = 0; i < equations.size(); i++) {
//            String from = equations.get(i).get(0);
//            String to = equations.get(i).get(1);
//            double weight = values[i];
//
//            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new WeightedPair(to, weight));
//            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new WeightedPair(from, 1.0 / weight));
//        }
//
//        // Process queries
//        double[] res = new double[queries.size()];
//        for (int i = 0; i < queries.size(); i++) {
//            String start = queries.get(i).get(0);
//            String end = queries.get(i).get(1);
//
//            // If either variable is not in the graph, return -1.0
//            if (!graph.containsKey(start) || !graph.containsKey(end)) {
//                res[i] = -1.0;
//            } else {
//                res[i] = bfs(graph, start, end);
//            }
//        }
//
//        return res;
//    }
//
//    // BFS to find the product of weights along the path
//    private static double bfs(Map<String, List<WeightedPair>> graph, String start, String end) {
//        Queue<WeightedPair> queue = new LinkedList<>();
//        Set<String> visited = new HashSet<>();
//        queue.add(new WeightedPair(start, 1.0));
//        visited.add(start);
//
//        while (!queue.isEmpty()) {
//            WeightedPair node = queue.poll();
//            String cur = node.dest;
//            double curWeight = node.weight;
//
//            if (cur.equals(end)) {
//                return BigDecimal.valueOf(curWeight).setScale(6, RoundingMode.HALF_UP).doubleValue();
//            }
//
//            for (WeightedPair neighbor : graph.get(cur)) {
//                if (!visited.contains(neighbor.dest)) {
//                    visited.add(neighbor.dest);
//                    queue.add(new WeightedPair(neighbor.dest, curWeight * neighbor.weight));
//                }
//            }
//        }
//
//        return -1.0; // No valid path found
//    }

    public static void main(String[] args) {
//        List<List<String>> equations = new ArrayList<>();
//
//        // Adding pairs of equations
//        equations.add(Arrays.asList("a", "b"));
//        equations.add(Arrays.asList("b", "c"));
//        equations.add(Arrays.asList("bc", "cd"));
//
//        double[] values = {1.5, 2.5, 5.0};
//
//        List<List<String>> queries = new ArrayList<>();
//        queries.add(Arrays.asList("a", "c"));
//        queries.add(Arrays.asList("c", "b"));
//        queries.add(Arrays.asList("bc", "cd"));
//        queries.add(Arrays.asList("cd", "bc"));
//        evaluate(equations, values, queries);

        System.out.println(5.234/2.455);
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"), Arrays.asList("a", "c"), Arrays.asList("d", "e"),
                Arrays.asList("d", "f"), Arrays.asList("a", "d"), Arrays.asList("aa", "bb"),
                Arrays.asList("aa", "cc"), Arrays.asList("dd", "ee"), Arrays.asList("dd", "ff"),
                Arrays.asList("aa", "dd"), Arrays.asList("a", "aa")
        );
        double[] values = {2.0, 3.0, 4.0, 5.0, 7.0, 5.0, 8.0, 9.0, 3.0, 2.0, 2.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("ff", "a")
        );

        double[] result = evaluate(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }
}
