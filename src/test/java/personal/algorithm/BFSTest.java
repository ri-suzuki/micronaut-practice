package personal.algorithm;

import org.junit.jupiter.api.Test;
import personal.bean.algorithm.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class BFSTest {
    final static int N = 7;
    final static int M = 7;

    @Test
    void bfsTest() {
        var bfs = new BFS();
        var graph = generateGraph();
        var dist = bfs.solve(N, 0, graph);

        graph.forEach((integer, integers) -> {
            System.out.printf(
                    "graph[%d]: %s",
                    integer,
                    integers.stream().map(node -> String.valueOf(node)).collect(Collectors.joining(",", "", "\n"))
            );
        });
        System.out.printf("-------------------------------\n");
        System.out.printf("start: %d%n", 0);
        for (
                int i = 0;
                i < N; i++) {
            System.out.printf("dist[%d]: %d%n", i, dist[i]);
        }

    }

    Map<Integer, List<Integer>> generateGraph() {
        var graph = new HashMap<Integer, List<Integer>>(N);

        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            var edge = toFrom();
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    int[] toFrom() {
        var to = ThreadLocalRandom.current().nextInt(BFSTest.N);
        var from = ThreadLocalRandom.current().nextInt(BFSTest.N);
        return new int[]{to, from};
    }

}
