package personal.bean.algorithm;

import java.util.*;

/**
 * BFS
 */
public class BFS {

    /**
     * @param n     node num
     * @param s     start node
     * @param graph graph
     * @return array from start node to each node.
     */
    public int[] solve(int n, int s, Map<Integer, List<Integer>> graph) {
        // init deque.
        Deque<Integer> deque = new ArrayDeque<>(graph.size());
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        // set start node.
        dist[s] = 0;
        deque.push(s);

        while (!deque.isEmpty()) {
            int v = deque.removeFirst();
            for (int nv : graph.get(v)) {
                if (dist[nv] != -1) {
                    continue;
                }
                dist[nv] = dist[v] + 1;
                deque.addLast(nv);
            }
        }
        return dist;
    }
}
