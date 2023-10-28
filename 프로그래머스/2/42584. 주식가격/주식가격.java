import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        final int[] ints = new int[prices.length];

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < prices.length - 1; i++) {
            int cur = prices[i];
            if (!q.isEmpty()) {
                while (prices[q.peekLast()] > cur) {
                    q.removeLast();
                    if (q.isEmpty()) {
                        break;
                    }
                }
            }

            q.addLast(i);

            for (final Integer integer : q) {
                ints[integer] = ints[integer] + 1;
            }
        }
        return ints;
    }
}