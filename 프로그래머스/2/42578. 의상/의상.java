import java.util.HashMap;
import java.util.Map;

class Solution {
public int solution(String[][] clothes) {
            Map<String, Integer> map = new HashMap<>();
            for (final String[] clothe : clothes) {
                final String s = clothe[0];
                final String type = clothe[1];
                if (!map.containsKey(type)) {
                    map.put(type, 1);
                } else {
                    map.put(type, map.get(type) + 1);
                }
            }
    
            int result = 1;
            for (final Integer value : map.values()) {
                result *= (value+1);
            }
            return result-1;
        }
}