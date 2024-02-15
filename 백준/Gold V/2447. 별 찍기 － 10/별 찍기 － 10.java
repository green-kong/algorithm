import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        recursive(0, 0, n, false);
        final StringBuilder sb = new StringBuilder();
        for (final String[] strings : map) {
            sb.append(String.join("", strings)).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(final int r, final int c, final int size, final boolean isBlank) {
        if (isBlank) {
            for (int i = r; i < r + size; i++) {
                for (int j = c; j < c + size; j++) {
                    map[i][j] = " ";
                }
            }
            return;
        }

        if (size == 1) {
            map[r][c] = "*";
            return;
        }

        final int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int newR = r + (i * newSize);
                int newC = c + (j * newSize);
                if (i == 1 && j == 1) {
                    recursive(newR, newC, newSize, true);
                    continue;
                }
                recursive(newR, newC, newSize, false);
            }
        }
    }
}
