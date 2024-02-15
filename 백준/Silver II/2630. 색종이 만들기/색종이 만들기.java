import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                final int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        func(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void func(final int r, final int c, final int size) {

        final int first = map[r][c];
        boolean flag = true;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != first) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        if (flag) {
            if (first == 1) {
                blue += 1;
            } else {
                white += 1;
            }
        } else {
            final int halfSize = size / 2;
            func(r, c, halfSize);
            func(r, c + halfSize, halfSize);
            func(r + halfSize, c, halfSize);
            func(r + halfSize, c + halfSize, halfSize);
        }
    }
}
