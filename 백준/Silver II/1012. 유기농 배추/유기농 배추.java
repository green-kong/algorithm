import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int c;
    static int r;

    public static void main(String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            int ans = 0;

            final StringTokenizer st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            final int n = Integer.parseInt(st.nextToken());
            map = new boolean[r][c];
            visited = new boolean[r][c];

            for (int j = 0; j < n; j++) {
                final StringTokenizer st2 = new StringTokenizer(br.readLine());
                final int cc = Integer.parseInt(st2.nextToken());
                final int cr = Integer.parseInt(st2.nextToken());
                map[cr][cc] = true;
            }

            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (map[j][k] && !visited[j][k]) {
                        dfs(j, k);
                        ans += 1;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static void dfs(final int cr, final int cc) {
        visited[cr][cc] = true;
        for (int i = 0; i < 4; i++) {
            final int nr = cr + dr[i];
            final int nc = cc + dc[i];

            if (0 <= nr && nr < r
                    && 0 <= nc && nc < c
                    && map[nr][nc]
                    && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
}
