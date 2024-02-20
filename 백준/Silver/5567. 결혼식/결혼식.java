import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Integer>[] arr;
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        final int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        arr = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int first = Integer.parseInt(st.nextToken());
            final int second = Integer.parseInt(st.nextToken());
            arr[first].add(second);
            arr[second].add(first);
        }
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        final Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            final Integer[] poll = q.poll();
            if (0 < poll[1] && poll[1] < 3) {
                ans += 1;
            }
            final List<Integer> list = arr[poll[0]];
            for (final Integer integer : list) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    q.offer(new Integer[]{integer, poll[1] + 1});
                }
            }
        }
    }
}
