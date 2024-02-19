import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //    7
//            1 6
//            6 3
//            3 5
//            4 1
//            2 4
//            4 7
    static List<Integer>[] arr;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        arr = new List[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int first = Integer.parseInt(st.nextToken());
            final int second = Integer.parseInt(st.nextToken());

            arr[first].add(second);
            arr[second].add(first);
        }

        dfs(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(final int cur) {
        visited[cur] = true;
        final List<Integer> list = arr[cur];
        for (final Integer integer : list) {
            if (!visited[integer]) {
                parent[integer] = cur;
                dfs(integer);
            }
        }
    }

}
