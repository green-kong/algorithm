import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // https://www.acmicpc.net/problem/11057

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(10);
            return;
        }

        final int[][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i < n + 1; i++) {
            for (int j = 9; j >= 0; j--) {
                if (j == 9) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = (dp[i][j + 1] + dp[i - 1][j]) % 10_007;
            }
        }

        int ans = 0;
        for (int i = 0; i < dp[n].length; i++) {
            ans = (dp[n][i] + ans) % 10_007;
        }
        System.out.println(ans);
    }
}
