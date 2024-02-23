import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            final int target = Integer.parseInt(br.readLine());

            if (target == 0) {
                System.out.println("1 0");
                continue;
            }

            if (target == 1) {
                System.out.println("0 1");
                continue;
            }

            int[][] dp = new int[target + 1][2];
            dp[0] = new int[]{1, 0};
            dp[1] = new int[]{0, 1};
            for (int j = 2; j < target + 1; j++) {
                dp[j] = new int[]{dp[j - 1][0] + dp[j - 2][0], dp[j - 1][1] + dp[j - 2][1]};
            }

            System.out.println(dp[target][0] + " " + dp[target][1]);

        }
    }
}
