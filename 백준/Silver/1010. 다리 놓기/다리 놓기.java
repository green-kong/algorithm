import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[30][30];

    private static void setUp() {
        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
    }


    public static void main(String[] args) throws IOException {
        setUp();
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {

            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int left = Integer.parseInt(st.nextToken());
            final int right = Integer.parseInt(st.nextToken());
//              n < r
//              left == right => 1
//              left = 2, right = 3 => left C right = 3
//              left = 3, right = 3 => left C right = 1
//              left = 3, right = 4 => left C right = 4
//
//               2 dp 3 => 3
//              2+1 dp 3 => 1
//              2+1 dp 3+1 = (2 dp 3) + (2+1 dp 3)
//            2 dp 3 = (2-1 dp 3-1) + 2 dp (3-1)
//            left dp right = (left-1 dp right-1) + (left dp right-1)
            System.out.println(dp[right][left]);
        }
    }
}
