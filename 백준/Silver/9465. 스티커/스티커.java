import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int colCnt;
    static int[][] dp;
    static int[][] stickers;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int z = 0; z < t; z++) {
            colCnt = Integer.parseInt(br.readLine());
            dp = new int[2][colCnt];
            stickers = new int[2][colCnt];
            isVisited = new boolean[2][colCnt];

            for (int i = 0; i < 2; i++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < colCnt; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            isVisited[0][colCnt - 1] = true;
            isVisited[1][colCnt - 1] = true;

            dp[0][colCnt - 1] = stickers[0][colCnt - 1];
            dp[1][colCnt - 1] = stickers[1][colCnt - 1];
            
            final int x = getSum(0, 0);
            final int y = getSum(1, 0);
            System.out.println(Math.max(x, y));
        }
    }

    private static int getSum(final int row, final int col) {
        if (isVisited[row][col]) {
            return dp[row][col];
        }

        isVisited[row][col] = true;
        final int nextRow = row == 0 ? 1 : 0;

        final int x = getSum(nextRow, col + 1);
        if (col + 1 == colCnt - 1) {
            dp[row][col] = x + stickers[row][col];
            return dp[row][col];
        }

        final int y = getSum(nextRow, col + 2);
        dp[row][col] = Math.max(x, y) + stickers[row][col];
        return dp[row][col];
    }
}
