package org.example.set3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ28298 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());
        final int k = Integer.parseInt(st.nextToken());

        List<String>[] group = new ArrayList[k * k];
        String[] answer = new String[4];
        int sum = 0;

        for (int i = 0; i < group.length; i++) {
            group[i] = new ArrayList<>();
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            final String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                map.put(split[j], 0);
                final int i1 = (j % k) + (i % k) * k;
                group[i1].add(split[j]);
            }
        }

        for (int i = 0; i< group.length; i++) {
            Map<String, Integer> copied = new HashMap<>(map);
            final List<String> strings = group[i];
            for (final String string : strings) {
                copied.put(string, copied.get(string) + 1);
            }

            int max = 0;
            String maxColour = null;

            for (final String s : copied.keySet()) {
                final int curCnt = copied.get(s);
                if (curCnt > max) {
                    max = curCnt;
                    maxColour = s;
                }
            }
            answer[i] = maxColour;
            sum += max;
        }
        System.out.println(n * m - sum);

    }
}
