import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        dp1 = 1
//        dp2 = 3
//        dp3 = 5 = 2+3 = 1*2 + 3
//        dp4 = 11 = 5+6 = 2*3 + 5
//        dp5 = 21
//        dp6 = 43
//        dp7 = 85
//        dp8 = 171
//        ...
//        dp[8] = 171
//        dp[n-1] + (2 * dp[n-2])
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        if (n == 2) {
            System.out.println(3);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10_007;
        }

        System.out.println(dp[n]);
    }
}
