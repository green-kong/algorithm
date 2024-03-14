import java.util.*;

class Solution {
    public int solution(int n, int k) {
    int ans = 0;
        String[] converted = Integer.toString(n, k).split("");
        Deque<String> dq = new LinkedList<>();

        for (String cur : converted) {
            if (cur.equals("0")) {
                if (!dq.isEmpty()) {
                    final long parseInt = Long.parseLong(String.join("", dq));
                    dq.clear();
                    if (check(parseInt)) {
                        ans += 1;
                    }
                }
                continue;
            }
            dq.addLast(cur);
        }
        if (!dq.isEmpty()) {
            final long parseInt = Long.parseLong(String.join("", dq));
            dq.clear();
            if (check(parseInt)) {
                ans += 1;
            }
        }
        return ans;    
    }
    
    private boolean check(final long number) {
        if (number == 1) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        final int floor = (int) Math.floor(Math.sqrt(number));
        for (int i = 2; i <= floor; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}