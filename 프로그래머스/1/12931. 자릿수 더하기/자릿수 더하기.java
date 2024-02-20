import java.util.*;

public class Solution {
    public int solution(int n) {
        final String s = String.valueOf(n);
        final String[] split = s.split("");
        return Arrays.stream(split)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}