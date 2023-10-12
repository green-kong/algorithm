package org.example.set2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13975 {
    public static void main(String[] args) throws IOException {
//        2
//        4
//        40 30 30 50
//        15
//        1 21 3 4 5 35 5 4 3 5 98 21 14 17 32

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int tc = Integer.parseInt(br.readLine());
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {

            final int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (pq.size() > 1) {

                final long x = pq.poll();
                final long y = pq.poll();

                sum += x + y;
                pq.offer(x + y);
            }
            sb.append(sum);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
