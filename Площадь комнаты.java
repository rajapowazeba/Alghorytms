import java.util.*;

public class Main {
    static char[][] grid;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        grid = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        int startRow = scanner.nextInt() - 1;
        int startCol = scanner.nextInt() - 1;
        System.out.println(bfs(startRow, startCol));
    }

    static int bfs(int x, int y) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int cx = cell[0], cy = cell[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n &&
                    grid[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    count++;
                }
            }
        }
        return count;
    }
}
