import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                final int cur = Integer.parseInt(st.nextToken());
                min = Math.min(cur, min);
                max = Math.max(cur, max);
                map[i][j] = cur;
            }
        }
        if (min == max) {
            System.out.println(1);
            return;
        }

        int ans = 1;

        for (int i = 0; i < max; i++) {
            boolean[][] visited = new boolean[n][n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && map[j][k] > i) {
                        bfs(j, k, i, visited);
                        sum += 1;
                    }
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

    private static void bfs(final int cr, final int cc, final int rain, final boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cr, cc});
        visited[cr][cc] = true;

        while (!q.isEmpty()) {
            final int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                final int nr = poll[0] + dr[i];
                final int nc = poll[1] + dc[i];

                if (0 <= nr && nr < n
                        && 0 <= nc && nc < n
                        && !visited[nr][nc]
                        && map[nr][nc] > rain) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
