import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int node;
    static int edge;
    static boolean[] visted;
    static boolean[][] edges;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        visted = new boolean[node + 1];
        edges = new boolean[node + 1][node + 1];

        for (int i = 0; i < edge; i++) {
            final StringTokenizer st2 = new StringTokenizer(br.readLine());
            final int first = Integer.parseInt(st2.nextToken());
            final int second = Integer.parseInt(st2.nextToken());
            edges[first][second] = true;
            edges[second][first] = true;
        }

        int answer = 0;
        for (int i = 1; i < visted.length; i++) {
            if (!visted[i]) {
                dfs(i);
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(final int cur) {
        visted[cur] = true;
        for (int i = 1; i < edges[cur].length; i++) {
            if (edges[cur][i] && !visted[i]) {
                dfs(i);
            }
        }

    }
}
