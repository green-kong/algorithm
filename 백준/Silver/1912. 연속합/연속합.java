import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/1912
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            final int beforeMaxSum = dp[i - 1];
            if (beforeMaxSum < 0) {
                dp[i] = arr[i];
            } else {
                dp[i] = arr[i] + beforeMaxSum;
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
