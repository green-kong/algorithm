package org.example.set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ1946 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {

            final int n = Integer.parseInt(br.readLine());

            final List<int[]> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                final String[] s = br.readLine().split(" ");
                list.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
            }

            final List<int[]> collect = list.stream()
                    .sorted((Comparator.comparingInt(o -> o[0])))
                    .collect(Collectors.toList());

            int cnt = 1;
            int bestScore = collect.get(0)[1];
            for (int j = 1; j < collect.size(); j++) {
                final int curScore = collect.get(j)[1];
                if (curScore < bestScore) {
                    bestScore = curScore;
                    cnt += 1;
                }
            }
            System.out.println(cnt);
        }
    }
}
