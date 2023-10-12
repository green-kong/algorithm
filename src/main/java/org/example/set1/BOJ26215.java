package org.example.set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ26215 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final Integer[] ints = new Integer[n];

        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(ints[0] > 1440 ? -1 : ints[0]);
            return;
        }
        int cnt = 0;
        Arrays.sort(ints, Comparator.reverseOrder());
        while(ints[0] > 0) {
            if(ints[1] == 0) {
                cnt += ints[0];
                break;
            }

            if (ints[0] >= ints[1]) {
                cnt += ints[1];
                ints[0] -= ints[1];
                ints[1] = 0;
            }
            Arrays.sort(ints, Comparator.reverseOrder());
        }
        System.out.println(cnt > 1440 ? -1 : cnt);
    }
}
