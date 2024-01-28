package exam20231030;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Five {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<List<int[]>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                int w = scanner.nextInt();
                graph.get(u).add(new int[]{v, w});
                graph.get(v).add(new int[]{u, w});
            }

            int left = 0;
            int right = Integer.MAX_VALUE;
            int result = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isStateUnchanged(graph, mid, n)) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(result);
        }

        public static boolean isStateUnchanged(List<List<int[]>> graph, int x, int n) {
            boolean[] visited = new boolean[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(graph, i, x, visited);
                    count++;
                }
            }

            return count == 1;
        }

        public static void dfs(List<List<int[]>> graph, int node, int x, boolean[] visited) {
            visited[node] = true;

            for (int[] neighbor : graph.get(node)) {
                if (!visited[neighbor[0]] && neighbor[1] > x) {
                    dfs(graph, neighbor[0], x, visited);
                }
            }
        }
}
