import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][2];
        dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int[] task = new int[2];
            task[0] = Integer.parseInt(st.nextToken());
            task[1] = Integer.parseInt(st.nextToken());
            arr[i] = task;
        }

        for (int i = n; i > 0; i--) {
            final int[] task = arr[i];
            final int date = task[0];
            final int reward = task[1];

            final int left = n - i + 1;
            if (left < date) {
                dp[i] = 0;
                for (int j = i + 1; j < n + 1; j++) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
                continue;
            }

            if (i + date <= n) {
                dp[i] = reward + dp[i + date];
            } else {
                dp[i] = reward;
            }
            for (int j = i + 1; j < i + date; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
        }

        final int i = Arrays.stream(dp)
                .max().orElse(0);
        System.out.println(i);
    }
}
