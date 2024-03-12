import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] wines;
    static int[] dp;
    static boolean[] isVisited;
    static int n;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wines = new int[n + 1];
        dp = new int[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(wines[1]);
            return;
        }

        dp[1] = wines[1];
        isVisited[0] = true;
        isVisited[1] = true;

        dp[2] = wines[1] + wines[2];
        isVisited[2] = true;

        final int x = getMax(n);
        final int y = getMax(n - 1);

        System.out.println(Math.max(x, y));
    }

    private static int getMax(final int idx) {
        if (isVisited[idx]) {
            return dp[idx];
        }

        isVisited[idx] = true;
        int z = 0;
        final int x = getMax(idx - 2);
        final int y = getMax(idx - 3) + wines[idx - 1];
        if (idx >= 4) {
            z = getMax(idx - 4) + wines[idx - 1];
        }
        final int curSum = Math.max(Math.max(x, y), z) + wines[idx];
        dp[idx] = curSum;
        return curSum;
    }
}
