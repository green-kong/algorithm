import java.util.*;
class Solution {
   public static double solution(int[] arr) {
        return Arrays.stream(arr)
                .average()
                .getAsDouble();
    }
}