import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] visited;
    static int[][] matrix;
    static int n;
    static int start = -1, end = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = scanner.nextInt();

        visited = new boolean[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(i)) {
                List<Integer> cycle = new ArrayList<>();
                for (int v = end; v != start; v = parent[v])
                    cycle.add(v + 1);
                cycle.add(start + 1);
                Collections.reverse(cycle);
                System.out.println("YES");
                System.out.println(cycle.size());
                for (int v : cycle)
                    System.out.print(v + " ");
                return;
            }
        }

        System.out.println("NO");
    }

    static boolean dfs(int v) {
        visited[v] = true;
        for (int u = 0; u < n; u++) {
            if (matrix[v][u] == 1) {
                if (!visited[u]) {
                    parent[u] = v;
                    if (dfs(u))
                        return true;
                } else if (u != parent[v]) {
                    start = u;
                    end = v;
                    return true;
                }
            }
        }
        return false;
    }
}
