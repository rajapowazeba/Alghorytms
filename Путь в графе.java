import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = scanner.nextInt();
        int s = scanner.nextInt() - 1;
        int e = scanner.nextInt() - 1;

        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 0; i < n; i++) {
                if (matrix[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    prev[i] = v;
                    queue.add(i);
                }
            }
        }

        if (!visited[e]) {
            System.out.println(-1);
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int v = e; v != -1; v = prev[v]) path.add(v + 1);
        Collections.reverse(path);
        System.out.println(path.size() - 1);
        if (path.size() > 1)
            for (int v : path) System.out.print(v + " ");
    }
}
