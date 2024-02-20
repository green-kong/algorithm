import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int r;
    static int c;
    static int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            ans = 0;
            final StringTokenizer st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            if (c == 0 && r == 0) {
                break;
            }

            map = new int[r][c];
            for (int i = 0; i < r; i++) {
                final StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    map[i][j] = Integer.parseInt(st2.nextToken());
                }
            }
            visited = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);
                        ans += 1;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static void dfs(final int cr, final int cc) {
        for (int i = 0; i < 8; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];
            if (0 <= nr && nr < r
                    && 0 <= nc && nc < c
                    && !visited[nr][nc]
                    && map[nr][nc] == 1) {
                visited[nr][nc] = true;
                dfs(nr, nc);
            }

        }
    }
}
