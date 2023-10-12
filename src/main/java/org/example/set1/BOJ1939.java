package org.example.set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1939 {

    static int x, y, n, b;
    static List<Node1939>[] graph;

    public static void main(String[] args) throws IOException {
        int lo = 0;
        int hi = 0;

        // 이분탐색
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < b; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int start = Integer.parseInt(st.nextToken());
            final int end = Integer.parseInt(st.nextToken());
            final int w = Integer.parseInt(st.nextToken());

            graph[start].add(new Node1939(end, w));
            graph[end].add(new Node1939(start, w));

            hi = Math.max(hi, w);
        }

        final String[] split = br.readLine().split(" ");
        x = Integer.parseInt(split[0]);
        y = Integer.parseInt(split[1]);

        int answer = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (bfs(mid)) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean bfs(int mid) {
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visit[x] = true;

        while (!q.isEmpty()) {
            final int poll = q.poll();
            if (poll == y) {
                return true;
            }

            final List<Node1939> nodes = graph[poll];

            for (final Node1939 node : nodes) {
                if (!visit[node.to] && node.w >= mid) {
                    visit[node.to] = true;
                    q.offer(node.to);
                }
            }
        }
        return false;
    }

    public static class Node1939 {
        int to;
        int w;

        public Node1939(final int to, final int w) {
            this.to = to;
            this.w = w;
        }
    }

}
