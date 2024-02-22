import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f, s, g, u, d;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        final int bfs = bfs();
        System.out.println(bfs == -1 ? "use the stairs" : bfs);
    }

    private static int bfs() {
        boolean[] visited = new boolean[f + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});

        while (!q.isEmpty()) {
            final int[] poll = q.poll();
            final int cur = poll[0];
            final int cnt = poll[1];
            if (cur == g) {
                return cnt;
            }
            if (cur + u <= f
                    && !visited[cur + u]) {
                visited[cur + u] = true;
                q.offer(new int[]{cur + u, cnt + 1});
            }
            if (cur - d >= 1
                    && !visited[cur - d]) {
                visited[cur - d] = true;
                q.offer(new int[]{cur - d, cnt + 1});
            }
        }
        return -1;
    }
}
