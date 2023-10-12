package org.example.set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775 {
    public static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            final int lev = Integer.parseInt(br.readLine());
            final int unit = Integer.parseInt(br.readLine());

            final int[][] apartment = new int[lev + 1][unit];

            for (int j = 0; j < unit; j++) {
                apartment[0][j] = j + 1;
            }

            for (int j = 1; j < lev + 1; j++) {
                for (int k = 0; k < unit; k++) {
                    if (k == 0) {
                        apartment[j][k] = 1;
                        continue;
                    }
                    apartment[j][k] = apartment[j][k - 1] + apartment[j - 1][k];
                }
            }
            sb.append(apartment[lev][unit - 1]);
            if (i != tc - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
