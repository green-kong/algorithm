package org.example.set2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1487 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            final String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int result = 0;
        int price = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            final int cost = arr[i][0];
            for (int j = i; j < arr.length; j++) {
                final int fee = arr[j][1];
                final int benefit = cost - fee;
                if (benefit > 0) {
                    sum += benefit;
                }
            }
            if (sum > result) {
                result = sum;
                price = cost;
            }
        }

        System.out.println(price);
    }
}
