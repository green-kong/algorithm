import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer>[] triangle;
    static List<Integer>[] dp;
    static List<Boolean>[] isVisited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        triangle = new List[n];
        dp = new List[n];
        isVisited = new List[n];
        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final List<Integer> row = new ArrayList<>();
            final List<Boolean> isVisitedRow = new ArrayList<>();
            final ArrayList<Integer> dpRow = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                row.add(Integer.parseInt(st.nextToken()));
                dpRow.add(0);
                isVisitedRow.add(false);
            }
            dp[i] = dpRow;
            triangle[i] = row;
            isVisited[i] = isVisitedRow;
        }

        dp[0] = List.of(triangle[0].get(0));
        isVisited[0] = List.of(true);

        final List<Integer> list = triangle[n - 1];
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(getSum(n - 1, i), max);
        }

        System.out.println(max);
    }

    private static int getSum(int row, int col) {
        if (Boolean.TRUE.equals(isVisited[row].get(col))) {
            return dp[row].get(col);
        }

        final int curLen = triangle[row].size();
        isVisited[row].set(col, true);

        if (col == 0) {
            final int curSum = getSum(row - 1, col) + triangle[row].get(col);
            dp[row].set(col, curSum);
            return dp[row].get(col);
        }

        if (col == curLen - 1) {
            final int curSum = getSum(row - 1, col - 1) + triangle[row].get(col);
            dp[row].set(col, curSum);
            return dp[row].get(col);
        }

        final int right = getSum(row - 1, col) + triangle[row].get(col);
        final int left = getSum(row - 1, col - 1) + triangle[row].get(col);
        dp[row].set(col, Math.max(right, left));
        return dp[row].get(col);
    }
}
