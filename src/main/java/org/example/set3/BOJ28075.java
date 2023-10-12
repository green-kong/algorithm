package org.example.set3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ28075 {

    static int[][] work = new int[2][3];
    static int n;
    static int m;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        for (int i = 0; i < 2; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                work[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count(-1, 0, 0);

        System.out.println(answer);
    }

    public static void count(int beforeJ, int day, int sum) {
        if (sum >= m && day == n) {
            answer += 1;
            return;
        }

        if (day == n) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                int x = work[i][j];
                if (j == beforeJ) {
                    x /= 2;
                }
                count(j, day + 1, sum + x);
            }
        }

    }
}
