import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int target;
    static int min = Integer.MAX_VALUE;
    static int[] arr = new int[100_001];
    static boolean[] visited = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int source = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        bfs(source);
    }

    private static void bfs(final int cur) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(cur);
        visited[cur] = true;
        arr[cur] = 0;
        while (!q.isEmpty()) {
            final int now = q.poll();
            if (now == target) {
                System.out.println(arr[now]);
                return;
            }
            if (0 <= now - 1 && now - 1 <= 100000 && !visited[now - 1]) {
                visited[now - 1] = true;
                arr[now - 1] = arr[now] + 1;
                q.offer(now - 1);
            }
            if (0 <= now + 1 && now + 1 <= 100000 && !visited[now + 1]) {
                visited[now + 1] = true;
                arr[now + 1] = arr[now] + 1;
                q.offer(now + 1);
            }
            if (0 <= now * 2 && now * 2 <= 100000 && !visited[now * 2]) {
                visited[now * 2] = true;
                arr[now * 2] = arr[now] + 1;
                q.offer(now * 2);
            }
        }
    }
}
