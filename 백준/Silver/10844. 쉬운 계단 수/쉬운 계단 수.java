import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //    https://www.acmicpc.net/problem/10844
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final long[][] dp = new long[n + 1][10];
        if (n == 1) {
            System.out.println(9);
            return;
        }

        Arrays.fill(dp[1], 1L);

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % 1_000_000_000;
                    continue;
                }

                if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % 1_000_000_000;
                    continue;
                }

                dp[i][j] = (dp[i - 1][j - 1] % 1_000_000_000 + dp[i - 1][j + 1] % 1_000_000_000) % 1_000_000_000;
            }
        }

        long ans = 0;
        for (int i = 1; i < 10; i++) {
            ans = (ans + dp[n][i]) % 1_000_000_000;
        }
        System.out.println(ans);
    }
}
