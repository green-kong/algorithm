import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int cnt = 0;
    public static boolean[] visited;
    static boolean[][] edges ;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        edges = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int s = Integer.parseInt(st.nextToken());
            final int t = Integer.parseInt(st.nextToken());
            edges[s][t] = true;
            edges[t][s] = true;
        }

        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(final int cur) {
        visited[cur] = true;
        final boolean[] curEdges = edges[cur];

        for (int i = 0; i < curEdges.length; i++) {
            if (curEdges[i] && !visited[i]) {
                cnt += 1;
                dfs(i);
            }
        }
    }
}
