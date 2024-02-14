import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int node;
    static int edge;
    static int start;
    static boolean[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        arr = new boolean[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            final StringTokenizer st2 = new StringTokenizer(br.readLine());
            final int node1 = Integer.parseInt(st2.nextToken());
            final int node2 = Integer.parseInt(st2.nextToken());
            arr[node1][node2] = true;
            arr[node2][node1] = true;
        }

        dfs(start);
        System.out.println(sb);
        sb = new StringBuilder();
        visited = new boolean[node + 1];
        bfs(start);
        System.out.println(sb);
    }

    private static void bfs(final int start) {
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            final int current = q.poll();
            sb.append(current).append(" ");

            for (int i = 1; i < arr[current].length; i++) {
                if (arr[current][i] && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(final int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        for (int i = 1; i < arr[start].length; i++) {
            if (arr[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}
