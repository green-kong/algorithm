import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int limit;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        arr = new int[n];
        final StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < n - 2; i++) {
            recursive(i, 1, arr[i]);
        }

        System.out.println(max);
    }

    private static void recursive(final int cur, final int cnt, final int sum) {
        if (cnt == 3) {
            if (sum <= limit) {
                max = Math.max(sum, max);
            }
            return;
        }

        for (int i = cur + 1; i < n; i++) {
            recursive(i, cnt + 1, sum + arr[i]);
        }
    }
}
//245 216 36
