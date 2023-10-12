package org.example.set2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ24049 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] s = br.readLine().split(" ");

        final int row = Integer.parseInt(s[0]);
        final int col = Integer.parseInt(s[1]);

        final int[][] arr = new int[row + 1][col + 1];

        final String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < s1.length; i++) {
            arr[i + 1][0] = Integer.parseInt(s1[i]);
        }

        final String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < s2.length; i++) {
            arr[0][i + 1] = Integer.parseInt(s2[i]);
        }

        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                arr[i][j] = arr[i - 1][j] == arr[i][j - 1] ? 0 : 1;
            }
        }
        System.out.println(arr[row][col]);
    }
}
