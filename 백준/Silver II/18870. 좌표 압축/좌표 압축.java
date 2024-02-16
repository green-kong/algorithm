import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            final int key = Integer.parseInt(st.nextToken());
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(i);
        }

        final Object[] objects = map.keySet().toArray();
        Arrays.sort(objects,Comparator.comparingInt(o1 -> (int) o1));
        for (int i = 0; i < objects.length; i++) {
            final List<Integer> list = map.get((int) objects[i]);
            for (final Integer integer : list) {
                ans[integer] = String.valueOf(i);
            }
        }
        System.out.println(String.join(" ", ans));
    }
}
