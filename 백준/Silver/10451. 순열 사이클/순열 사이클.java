import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] edges;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int answer = 0;
            final int m = Integer.parseInt(br.readLine());
            final StringTokenizer st = new StringTokenizer(br.readLine());
            edges = new boolean[m + 1][m + 1];
            visited = new boolean[m + 1];

            for (int j = 1; j < m + 1; j++) {
                final int node = Integer.parseInt(st.nextToken());
                edges[j][node] = true;
            }

            for (int j = 1; j < visited.length; j++) {
                if (!visited[j]) {
                    dfs(j);
                    answer += 1;
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(final int cur) {
        visited[cur] = true;
        for (int i = 0; i < edges[cur].length; i++) {
            if (edges[cur][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}
