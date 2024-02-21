import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int r;
    static int c;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            final String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        boolean[][] visited = new boolean[r][c];

        visited[0][0] = true;
        final int ans = bfs(0, 0, 1, visited);

        System.out.println(ans);
    }

    private static int bfs(final int cr, final int cc, final int cnt, final boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cr, cc, cnt});
        while (!q.isEmpty()) {
            final int[] poll = q.poll();
            if (poll[0] == r - 1 && poll[1] == c - 1) {
                return poll[2];
            }
            for (int i = 0; i < 4; i++) {
                final int nr = poll[0] + dr[i];
                final int nc = poll[1] + dc[i];

                if (0 <= nr && nr < r
                        && 0 <= nc && nc < c
                        && !visited[nr][nc]
                        && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, poll[2] + 1});
                }
            }
        }
        return 0;
    }

    private static boolean[][] copyVisited(final boolean[][] visited) {
        final boolean[][] copiedVisited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                copiedVisited[i][j] = visited[i][j];
            }
        }
        return copiedVisited;
    }
}
