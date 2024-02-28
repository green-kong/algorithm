import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // https://www.acmicpc.net/problem/11055
    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i >= 0; i--) {
            recursive(i);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    private static int recursive(final int curIdx) {
        if (dp[curIdx] != 0) {
            return dp[curIdx];
        }
        int max = 0;
        for (int i = curIdx - 1; i >= 0; i--) {
            if (arr[i] < arr[curIdx]) {
                max = Math.max(max, recursive(i));
            }
        }
        dp[curIdx] = max + arr[curIdx];
        return dp[curIdx];
    }
}
