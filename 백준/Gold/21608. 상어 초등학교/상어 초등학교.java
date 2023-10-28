import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    //    3
//            4 2 5 1 7
//            3 1 9 4 5
//            9 8 1 2 3
//            8 1 9 3 4
//            7 2 3 4 8
//            1 9 2 5 7
//            6 5 2 3 4
//            5 1 9 2 8
//            2 9 3 1 4
    static int[][] map;
    static int[][] favorite;
    static boolean[] sit;
    static Map<Integer, Integer[]> location = new HashMap<>();
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        favorite = new int[n * n + 1][4];
        sit = new boolean[n * n + 1];

        for (int i = 0; i < n * n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int sNum = Integer.parseInt(st.nextToken());

            final int[] fav = new int[4];
            for (int j = 0; j < 4; j++) {
                fav[j] = Integer.parseInt(st.nextToken());
            }
            favorite[sNum] = fav;

            if (i == 0) {
                sit[sNum] = true;
                map[1][1] = sNum;
                location.put(sNum, new Integer[]{1, 1});
                continue;
            }

            List<Integer> sittedFav = new ArrayList<>();
            for (final int i1 : fav) {
                if (sit[i1]) {
                    sittedFav.add(i1);
                }
            }

            if (sittedFav.isEmpty()) {
                int max = -1;
                int[] place = new int[2];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {

                        int cur = map[j][k];
                        if (cur > 0) {
                            continue;
                        }
                        int cnt = 0;

                        for (int l = 0; l < 4; l++) {
                            final int nr = j + dr[l];
                            final int nc = k + dc[l];

                            if (0 <= nr && nr < n
                                    && 0 <= nc && nc < n
                                    && map[nr][nc] == 0) {
                                cnt += 1;
                            }

                        }
                        if (cnt > max) {
                            max = cnt;
                            place = new int[]{j, k};
                        }
                    }
                }
                map[place[0]][place[1]] = sNum;
                sit[sNum] = true;
                location.put(sNum, new Integer[]{place[0], place[1]});
                continue;
            }

            int maxFavCnt = Integer.MIN_VALUE;
            List<Integer[]> candidates = new ArrayList<>();

            for (final Integer fNum : sittedFav) {

                final Integer[] integers = location.get(fNum);
                for (int j = 0; j < 4; j++) {
                    final int nr = integers[0] + dr[j];
                    final int nc = integers[1] + dc[j];

                    if (0 <= nr && nr < n
                            && 0 <= nc && nc < n
                            && map[nr][nc] == 0) {

                        int tmp = 0;

                        for (int k = 0; k < 4; k++) {
                            final int nnr = nr + dr[k];
                            final int nnc = nc + dc[k];

                            if (0 <= nnr && nnr < n
                                    && 0 <= nnc && nnc < n) {
                                if (sittedFav.contains(map[nnr][nnc])) {
                                    tmp += 1;
                                }
                            }
                        }

                        if (tmp > maxFavCnt) {
                            candidates.clear();
                            candidates.add(new Integer[]{nr, nc});
                            maxFavCnt = tmp;
                            continue;
                        }

                        if (tmp == maxFavCnt) {
                            candidates.add(new Integer[]{nr, nc});
                        }
                    }
                }
            }
            if (candidates.isEmpty()) {
                int max = -1;
                int[] place = new int[2];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {

                        int cur = map[j][k];
                        if (cur > 0) {
                            continue;
                        }
                        int cnt = 0;

                        for (int l = 0; l < 4; l++) {
                            final int nr = j + dr[l];
                            final int nc = k + dc[l];

                            if (0 <= nr && nr < n
                                    && 0 <= nc && nc < n
                                    && map[nr][nc] == 0) {
                                cnt += 1;
                            }

                        }
                        if (cnt > max) {
                            max = cnt;
                            place = new int[]{j, k};
                        }
                    }
                }
                map[place[0]][place[1]] = sNum;
                sit[sNum] = true;
                location.put(sNum, new Integer[]{place[0], place[1]});
                continue;
            }
            if (candidates.size() == 1) {
                final Integer[] integers = candidates.get(0);
                map[integers[0]][integers[1]] = sNum;
                sit[sNum] = true;
                location.put(sNum, new Integer[]{integers[0], integers[1]});
                continue;
            }

            List<Integer[]> candidates1 = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (final Integer[] candidate : candidates) {
                int tmp = 0;
                for (int j = 0; j < 4; j++) {
                    final int nr = candidate[0] + dr[j];
                    final int nc = candidate[1] + dc[j];

                    if (0 <= nr && nr < n
                            && 0 <= nc && nc < n) {
                        if (map[nr][nc] == 0) {
                            tmp += 1;
                        }
                    }
                }

                if (tmp > max) {
                    candidates1.clear();
                    candidates1.add(candidate);
                    max = tmp;
                    continue;
                }

                if (tmp == max) {
                    candidates1.add(candidate);
                }
            }

            if (candidates1.size() == 1) {
                final Integer[] integers = candidates1.get(0);
                map[integers[0]][integers[1]] = sNum;
                sit[sNum] = true;
                location.put(sNum, new Integer[]{integers[0], integers[1]});
                continue;
            }

            final List<Integer[]> sorted = candidates1.stream()
                    .sorted(((o1, o2) -> {
                        if (o2[0].equals(o1[0])) {
                            return o1[1] - o2[1];
                        }
                        return o1[0] - o2[0];
                    }))
                    .collect(Collectors.toList());

            final Integer[] integers = sorted.get(0);
            map[integers[0]][integers[1]] = sNum;
            sit[sNum] = true;
            location.put(sNum, new Integer[]{integers[0], integers[1]});
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int cur = map[i][j];
                int cnt = 0;

                for (int k = 0; k < 4; k++) {
                    final int nr = i + dr[k];
                    final int nc = j + dc[k];

                    if (0 <= nr && nr < n
                            && 0 <= nc && nc < n) {
                        int close = map[nr][nc];
                        final int[] ints = favorite[cur];
                        for (final int anInt : ints) {
                            if (anInt == close) {
                                cnt += 1;
                            }
                        }
                    }
                }
                if (cnt > 0) {
                    answer += Math.pow(10, (double) cnt - 1);
                }
            }
        }

        System.out.println(answer);
    }
}
