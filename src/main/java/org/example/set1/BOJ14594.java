package org.example.set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14594 {
    public static void main(String[] args) throws IOException {
//        첫 번째 줄에는 동아리방의 개수를 나타내는 양의 정수 N(2 ≤ N ≤ 100) 이 주어진다.
//        두 번째 줄에는 빅-종빈빌런의 행동 횟수를 나타내는 음이 아닌 정수 M(0 ≤ M ≤ 100) 이 주어진다.
//        세 번째 줄부터 M개의 줄에 걸쳐 빅-종빈빌런의 행동이 양의 정수 x, y(1 ≤ x < y ≤ N) 로 주어진다.
//        여기서 행동이란 x번 방부터 y번 방 사이의 벽을 무너뜨리는 것을 의미한다.
//        빅-종빈빌런은 매우 허당이기 때문에 동일한 행동을 여러 번 할 수 있음에 유의하라.

//        5
//        2
//        1 2
//        2 4

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int roomCnt = Integer.parseInt(br.readLine());
        final boolean[] walls = new boolean[roomCnt - 1];

        final int tryCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < tryCnt; i++) {

            final String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            while (start < end) {
                walls[start - 1] = true;
                start += 1;
            }
        }
        int availableRoomCnt = 1;
        for (final boolean wall : walls) {
            if (!wall) {
                availableRoomCnt += 1;
            }
        }
        System.out.println(availableRoomCnt);
    }
}
