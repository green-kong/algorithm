import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static String[][] map;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];
        for (int i = 0; i < r; i++) {
            final String[] split = br.readLine().split("");
            map[i] = split;
        }
        int ans = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j].equals("L")) {
                    final int bfs = bfs(i, j);
                    ans = Math.max(ans, bfs);
                }
            }
        }

        System.out.println(ans);
    }

    private static int bfs(int cr, int cc) {
        boolean[][] visited = new boolean[r][c];
        visited[cr][cc] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cr, cc, 0});

        int max = 0;

        while (!q.isEmpty()) {
            final int[] poll = q.poll();
            max = poll[2];
            for (int i = 0; i < 4; i++) {
                final int nr = poll[0] + dr[i];
                final int nc = poll[1] + dc[i];

                if (0 <= nr && nr < r
                        && 0 <= nc && nc < c
                        && !visited[nr][nc]
                        && map[nr][nc].equals("L")) {
                    visited[nr][nc] = true;
                    final int parseInt = poll[2] + 1;
                    q.offer(new int[]{nr, nc, parseInt});
                }
            }
        }
        return max;
    }
}
