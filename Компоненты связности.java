import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static List<List<Integer>> components;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n + 1];
        components = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, component);
                components.add(component);
            }
        }

        System.out.println(components.size());
        for (List<Integer> component : components) {
            System.out.println(component.size());
            for (int v : component) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int v, List<Integer> component) {
        visited[v] = true;
        component.add(v);
        for (int u : graph.get(v)) {
            if (!visited[u]) {
                dfs(u, component);
            }
        }
    }
}
