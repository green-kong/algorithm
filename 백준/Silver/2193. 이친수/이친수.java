import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        long[][] dp = new long[n + 1][2];
        dp[1] = new long[]{0, 1};

        for (int i = 2; i < n+1; i++) {
            final long[] before = dp[i - 1];
            dp[i] = new long[]{before[1] + before[0], before[0]};
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}
