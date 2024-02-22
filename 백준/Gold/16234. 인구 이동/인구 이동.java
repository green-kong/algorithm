import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int l;
    static int r;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static List<List<int[]>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            final StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            list = new ArrayList<>();
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        checkCell(i, j);
                    }
                }
            }
            if (list.isEmpty()) {
                break;
            }
            move();
            ans += 1;
        }
        System.out.println(ans);
    }

    private static void move() {
        for (final List<int[]> ints : list) {
            final int avg = (int) ints.stream()
                    .mapToInt(co -> map[co[0]][co[1]])
                    .average()
                    .getAsDouble();

            ints.forEach(co -> map[co[0]][co[1]] = avg);
        }
    }

    private static void checkCell(int cr, int cc) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        q.offer(new int[]{cr, cc});

        while (!q.isEmpty()) {
            final int[] poll = q.poll();
            if (visited[poll[0]][poll[1]]) {
                continue;
            }
            visited[poll[0]][poll[1]] = true;
            union.add(new int[]{poll[0], poll[1]});

            for (int i = 0; i < 4; i++) {
                final int nr = poll[0] + dr[i];
                final int nc = poll[1] + dc[i];

                if (0 <= nr && nr < n
                        && 0 <= nc && nc < n
                        && !visited[nr][nc]) {
                    final int nxt = map[nr][nc];
                    final int cur = map[poll[0]][poll[1]];
                    final int gap = Math.abs(cur - nxt);
                    if (l <= gap && gap <= r) {
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        if (union.size() > 1) {
            list.add(union);
        }
    }

}
