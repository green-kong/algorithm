import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final long[] dp = new long[n + 1];

        if (n <= 6) {
            System.out.println(n);
            return;
        }

        for (int i = 0; i < 7; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            dp[i] = Math.max(dp[i], dp[i - 4] * 3);
            dp[i] = Math.max(dp[i], dp[i - 5] * 4);
        }

        System.out.println(dp[n]);
    }
}
