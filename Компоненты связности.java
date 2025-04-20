import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            union(u, v);
        }

        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int root = find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        System.out.println(components.size());
        for (List<Integer> comp : components.values()) {
            System.out.println(comp.size());
            for (int v : comp) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) return;
        if (rank[rx] < rank[ry]) {
            parent[rx] = ry;
        } else {
            parent[ry] = rx;
            if (rank[rx] == rank[ry]) {
                rank[rx]++;
            }
        }
    }
}
