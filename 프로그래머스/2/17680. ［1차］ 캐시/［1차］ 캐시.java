import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
            Queue<String> q = new LinkedList<>();

            int cnt = 0;

            if(cacheSize == 0) {
                return 5 * cities.length;
            }

            for (int i = 0; i < cities.length; i++) {
                final String city = cities[i].toLowerCase();
                final boolean contains = q.contains(city);
                if (contains) {
                    q.remove(city);
                    q.offer(city);
                    cnt += 1;
                } else {
                    if (q.size() == cacheSize) {
                        q.poll();
                    }
                    q.offer(city);
                    cnt += 5;
                }
            }

            return cnt;
        }
}