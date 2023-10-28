import java.util.*;

public class Solution {
    public int solution(int n) {
            int usage = 1;

            while (n > 1) {
                if (n % 2 != 0) {
                    usage += 1;
                }
                n /= 2;
            }
            return usage;
        }
}