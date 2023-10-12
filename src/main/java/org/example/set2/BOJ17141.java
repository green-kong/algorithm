package org.example.set2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17141 {
    static List<int[]> available = new ArrayList<>();
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};
    static boolean[] isSet;
    static int[][] arr;
    static int n, m, cellCnt;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    available.add(new int[]{i, j});
                }
                if (arr[i][j] == 0) {
                    cellCnt++;
                }
            }
        }

        isSet = new boolean[available.size()];
        cellCnt += available.size() - m;

        if (cellCnt == 0) {
            answer = 0;
        }else {
            dfs(0,0 );
        }

        System.out.println(answer);
    }

    public static void dfs(int count, int start) {
        if (count == m) {
            int[][] copied = copy();
            bfs(copied, cellCnt);
            return;
        }

        for (int i = start; i < available.size(); i++) {
            isSet[i] = true;
            dfs(count + 1, start + 1);
            isSet[i] = false;
        }
    }

    public static int[][] copy() {
        int[][] copied = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copied[i][j] = (arr[i][j] == 2 ? 0 : arr[i][j]);
            }
        }

        for (int i = 0; i < isSet.length; i++) {
            if (isSet[i]) {
                final int[] ints = available.get(i);
                copied[ints[0]][ints[1]] = 2;
            }
        }

        return copied;
    }

    public static void bfs(int[][] map, int count) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < isSet.length; i++) {
            if (isSet[i]) {
                q.offer(available.get(i));
            }
        }

        int sec = 0;

        while (!q.isEmpty()) {
            if (answer <= sec) {
                break;
            }

            final int length = q.size();

            for (int i = 0; i < length; i++) {
                final int[] poll = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = poll[0] + dy[j];
                    int nc = poll[1] + dx[j];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n){
                        continue;
                    }

                    if (map[nr][nc] != 0) {
                        continue;
                    }

                    map[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                    count--;
                }
            }
            sec++;
            if (count == 0) {
                answer = sec;
                return;
            }
        }
    }
}
